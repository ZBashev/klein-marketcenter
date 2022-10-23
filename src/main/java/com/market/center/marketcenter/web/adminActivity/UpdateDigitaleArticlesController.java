package com.market.center.marketcenter.web.adminActivity;


import com.market.center.marketcenter.models.serviceModels.UpdateDiagitaleArtServiceModel;
import com.market.center.marketcenter.models.serviceViewModels.ArticleDigitaleViewModel;
import com.market.center.marketcenter.repositoies.ArticleDigitaleRepository;
import com.market.center.marketcenter.services.ArticleDigitaleService;
import com.market.center.marketcenter.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.MessageRemovedException;
import javax.validation.Valid;

@Controller
@RequestMapping("/update")
public class UpdateDigitaleArticlesController {


    private final UserService userService;
    private final ArticleDigitaleService articleDigitaleService;
    private  final ArticleDigitaleRepository articleDigitaleRepository;

    public UpdateDigitaleArticlesController(UserService userService, ArticleDigitaleService articleDigitaleService,
                                            ArticleDigitaleRepository articleDigitaleRepository) {
        this.userService = userService;
        this.articleDigitaleService = articleDigitaleService;
        this.articleDigitaleRepository = articleDigitaleRepository;
    }


    @GetMapping("/article/{id}")
    public String viewUpdatePage(@PathVariable("id") String id, Model model) throws Exception {


        if (!(model.containsAttribute("articleDigitaleViewModel"))) {
            model.addAttribute("articleDigitaleViewModel", new ArticleDigitaleViewModel());

        }


//        model.addAttribute("articleDigitaleViewModel", this.articleDigitaleService.findArticleById(id));


        if (this.articleDigitaleRepository.findById(id).isPresent()) {

            ArticleDigitaleViewModel articleDigitaleViewModel=
                    this.articleDigitaleService.findArticleById(id);
            model.addAttribute("articleDigitaleViewModel", articleDigitaleViewModel);
        }else {

            Exception IllegalArgumentException = new MessageRemovedException("MAMKA MU  упдате");
            throw IllegalArgumentException;
        }

      /*  String currentUser = this.userService.helloUser();
        model.addAttribute("hello", currentUser);*/

        return "adminResources/update-digitale-articles";
    }


    @PatchMapping("/digitale")
    public String udateArticlre(@Valid UpdateDiagitaleArtServiceModel updateDiagitaleArtServiceModel,
                                BindingResult bindingResult, RedirectAttributes redirectAttributes) {


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute(
                    "updateDiagitaleArtServiceModel", updateDiagitaleArtServiceModel);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.updateDiagitaleArtServiceModel",
                    bindingResult);


            return "redirect:/update/article/{id}";
        }


        this.articleDigitaleService.updateDigitaleArticle(updateDiagitaleArtServiceModel);

        return "redirect:/online/win";


    }


}
