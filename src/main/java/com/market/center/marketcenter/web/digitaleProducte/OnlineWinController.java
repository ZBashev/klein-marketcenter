package com.market.center.marketcenter.web.digitaleProducte;


import com.market.center.marketcenter.models.serviceViewModels.ArticleDigitaleViewModel;
import com.market.center.marketcenter.services.ArticleDigitaleService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.market.center.marketcenter.models.entity.enumerationsArticlesCategories.DigitaleProdukteEnumeration.ONLINE_VERDIENEN;


@Controller
@RequestMapping("/online")
public class OnlineWinController {



    private final ArticleDigitaleService articleDigitaleService;


    public OnlineWinController(
                               ArticleDigitaleService articleDigitaleService) {

        this.articleDigitaleService = articleDigitaleService;
    }

    @GetMapping("/win")
    public String viewOnlineVerdienenOffers(Model model) {


        ResponseEntity<List<ArticleDigitaleViewModel>> list =
                articleDigitaleService.findAllCategoryByEnum(ONLINE_VERDIENEN);


        if (!(model.containsAttribute("viewArticles"))) {

            model.addAttribute("viewArticles",new ArticleDigitaleViewModel());
        }

        model.addAttribute("viewArticles",list.getBody());








        String category = "ONLINE_VERDIENEN_DIGITALE";




        return "digitaleProdukte/online-win";

    }


}
