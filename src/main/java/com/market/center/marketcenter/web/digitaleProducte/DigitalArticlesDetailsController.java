package com.market.center.marketcenter.web.digitaleProducte;

import com.market.center.marketcenter.models.entity.ArticleDigitaleEntity;
import com.market.center.marketcenter.models.serviceViewModels.ArticleDigitaleViewModel;
import com.market.center.marketcenter.repositoies.ArticleDigitaleRepository;
import com.market.center.marketcenter.services.ArticleDigitaleService;
import com.market.center.marketcenter.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.Message;
import javax.mail.MessageRemovedException;


@Controller
//@RequestMapping("/article")
public class DigitalArticlesDetailsController {

    private final ArticleDigitaleService articleDigitaleService;

    private final UserService userService;

    private final ArticleDigitaleRepository articleDigitaleRepository;
    private  final ModelMapper modelMapper;

    public DigitalArticlesDetailsController(ArticleDigitaleService articleDigitaleService, UserService userService,
                                            ArticleDigitaleRepository articleDigitaleRepository, ModelMapper modelMapper) {
        this.articleDigitaleService = articleDigitaleService;
        this.userService = userService;
        this.articleDigitaleRepository = articleDigitaleRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/detail/{id}")

    public String viewArticleDetailsById(  @PathVariable("id") String id, Model model) throws Exception {
/*

        if (model.containsAttribute("onlineWinArticle")) {
            model.addAttribute("onlineWinArticle", new ArticleDigitaleViewModel());


        }

*/




        if (this.articleDigitaleRepository.findById(id).isPresent()) {

            ArticleDigitaleViewModel articleDigitaleViewModel=
                    this.articleDigitaleService.findArticleById(id);
            model.addAttribute("onlineWinArticle", articleDigitaleViewModel);
        }else {

            Exception IllegalArgumentException = new MessageRemovedException("MAMKA MU детаилс");
            throw IllegalArgumentException;
        }










    /*    String currentUser = this.userService.helloUser();
        model.addAttribute("hello", currentUser);*/


        return "digitaleProdukte/win-article-details";


    }


    @DeleteMapping("/clean/{id}")
    public String cleanArticles(@PathVariable("id") String id) {
        this.articleDigitaleService.deleteArticles(id);

        return "digitaleProdukte/online-win";
    }


}
