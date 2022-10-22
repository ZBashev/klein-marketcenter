package com.market.center.marketcenter.web.adminActivity;


import com.market.center.marketcenter.services.ArticleDigitaleService;
import com.market.center.marketcenter.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.market.center.marketcenter.models.bindingModels.ArticlesDigitaleBindingModels;

import javax.validation.Valid;

@Controller
@RequestMapping("/articles")
public class AddDigitaleArticlesController {

    private final ArticleDigitaleService articleDigitaleService;
    private final UserService userService;


    public AddDigitaleArticlesController(ArticleDigitaleService articleDigitaleService, UserService userService) {
        this.articleDigitaleService = articleDigitaleService;

        this.userService = userService;
    }


    @GetMapping("/add")
    public String addArticles(Model model) {


        if (!model.containsAttribute("articlesDigitaleBindingModels")) {
            model.addAttribute("articlesDigitaleBindingModels", new ArticlesDigitaleBindingModels());
        }
        String currentUser = this.userService.helloUser();
        model.addAttribute("hello", currentUser);

        return "adminResources/add-article-digitale";
    }


    @PostMapping("/addArticle")
    public String addArticlesDigitale(@Valid ArticlesDigitaleBindingModels articlesDigitaleBindingModels,
                                      BindingResult bindingResult,
                                      RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("articlesDigitaleBindingModels"
                    , articlesDigitaleBindingModels);
            redirectAttributes.addFlashAttribute(
                    "org.springframework.validation.BindingResult.articlesDigitaleBindingModels",
                    bindingResult);

            return "redirect:/articles/addArticle";
        }

        this.articleDigitaleService.addNewDigitaleArticles(articlesDigitaleBindingModels);


        return "adminResources/add-article-digitale";
    }
}
