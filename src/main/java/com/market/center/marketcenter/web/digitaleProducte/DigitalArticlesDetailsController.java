package com.market.center.marketcenter.web.digitaleProducte;

import com.market.center.marketcenter.models.entity.ArticleDigitaleEntity;
import com.market.center.marketcenter.models.serviceViewModels.ArticleDigitaleViewModel;
import com.market.center.marketcenter.models.serviceViewModels.ArticleViewModel;
import com.market.center.marketcenter.services.ArticleDigitaleService;
import com.market.center.marketcenter.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/article")
public class DigitalArticlesDetailsController {

    private final ArticleDigitaleService articleDigitaleService;

    private final UserService userService;

    public DigitalArticlesDetailsController(ArticleDigitaleService articleDigitaleService, UserService userService) {
        this.articleDigitaleService = articleDigitaleService;
        this.userService = userService;
    }

    @GetMapping("/detail/{id}")

    public String viewArticleDetailsById(@PathVariable String id, Model model) {

        if (model.containsAttribute("onlineWinArticle")) {
            model.addAttribute("onlineWinArticle", new ArticleDigitaleViewModel());
//            model.addAttribute("createMetaTagsInPage", new ArticleDigitaleViewModel());

        }

        ArticleDigitaleViewModel articleDigitaleViewModel = this.articleDigitaleService.findArticleById(id);


        model.addAttribute("onlineWinArticle", articleDigitaleViewModel);

//        ArticleDigitaleViewModel meta=this.articleDigitaleService.findArticleById(id);


//      model.addAttribute("createMetaTagsInPage", meta);


        String currentUser = this.userService.helloUser();
        model.addAttribute("hello", currentUser);


        return "digitaleProdukte/win-article-details";


    }


    @DeleteMapping("/clean/{id}")
    public String cleanArticles(@PathVariable("id") String id) {
        this.articleDigitaleService.deleteArticles(id);

        return "digitaleProdukte/online-win";
    }


}
