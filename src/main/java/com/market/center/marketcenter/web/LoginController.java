package com.market.center.marketcenter.web;


import com.market.center.marketcenter.models.bindingModels.UserLoginBindingModel;
import com.market.center.marketcenter.models.serviceModels.UserLoginServiceModel;
import com.market.center.marketcenter.services.CarouselService;
import com.market.center.marketcenter.services.UserService;
import org.jetbrains.annotations.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class LoginController {


    private final CarouselService carouselService;
    private final UserService userService;
    private final ModelMapper modelMapper;


    public LoginController(CarouselService carouselService, UserService userService, ModelMapper modelMapper
    ) {
        this.carouselService = carouselService;
        this.userService = userService;
        this.modelMapper = modelMapper;

    }


    @GetMapping("/login")
    public String login(@NotNull Model model) {

        model.addAttribute("firstImg", this.carouselService.firstImage());
        model.addAttribute("secondImg", this.carouselService.secondImage());
        model.addAttribute("thirdImg", this.carouselService.thirdImage());
        model.addAttribute("fourthImg", this.carouselService.fourthImg());


        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());

            model.addAttribute("bad_credentials");
            model.addAttribute("username");
        }


        return "login";
    }


    @PostMapping("/login")
    public String login(@Valid UserLoginBindingModel userLoginBindingModel,
                        BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);


            return "redirect:/users/login";
        }
        this.mapUsers(userLoginBindingModel);


        return "index";
    }


    @PostMapping("/login-error")
    public String failedLogin(@ModelAttribute(
            value = UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY)
                                      String username, RedirectAttributes redirectAttributes) {


        redirectAttributes.addFlashAttribute("bad_credentials", true);
        redirectAttributes.addFlashAttribute("username", username);


        return "redirect:/users/login";
    }


    private void mapUsers(UserLoginBindingModel userLoginBindingModel) {


        UserLoginServiceModel userLoginServiceModel = this.modelMapper
                .map(userLoginBindingModel, UserLoginServiceModel.class);

        this.userService.loginUsers(userLoginServiceModel);

    }


}
