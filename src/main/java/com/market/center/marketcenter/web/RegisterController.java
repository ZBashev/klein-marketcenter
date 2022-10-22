package com.market.center.marketcenter.web;


import com.market.center.marketcenter.models.bindingModels.UserRegisterBindingModel;
import com.market.center.marketcenter.models.serviceModels.UserRegisterServiceModel;
import com.market.center.marketcenter.services.UserService;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class RegisterController {

    private final UserService userService;

    private final ModelMapper modelMapper;


    public RegisterController(UserService userService,
                              ModelMapper modelMapper) {
        this.userService = userService;

        this.modelMapper = modelMapper;

    }


    @GetMapping("/register")
    public String register(Model model) {

        if (!model.containsAttribute("userRegisterBindingModel")) {

            model.addAttribute("userRegisterBindingModel", new UserRegisterBindingModel());
            model.addAttribute("existingUsername");
            model.addAttribute("existingEmail");
            model.addAttribute("failledPassword");


        }



        return "register";
    }


    @PostMapping("/register")
    public String ConfirmPassword(@Validated UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult, RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:/users/register";
        }


        if (this.userService.existingUsername(userRegisterBindingModel.getUsername())) {

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("existingUsername", true);

            return "redirect:/users/register";

        }

        else if (this.userService.existingEmail(userRegisterBindingModel.getEmail())) {

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("existingEmail", true);


            return "redirect:/users/register";
        }



        else if (this.userService.confirmPassword(userRegisterBindingModel.getConfirmPassword(),
                userRegisterBindingModel.getPassword())){
            redirectAttributes.addFlashAttribute("userRegisterBindingModel",userRegisterBindingModel);
            redirectAttributes.addAttribute("failledPassword",false);


            return "redirect:/users/register";

        }

        this.mapUserRegister(userRegisterBindingModel);


        return "redirect:/users/login";
    }

    private void mapUserRegister(UserRegisterBindingModel userRegisterBindingModel) {


        UserRegisterServiceModel userRegisterServiceModel = this.modelMapper.map(
                userRegisterBindingModel, UserRegisterServiceModel.class
        );

        this.userService.addUserRegister(userRegisterServiceModel);

    }


}
