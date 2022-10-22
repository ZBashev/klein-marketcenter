package com.market.center.marketcenter.web.restDigitaleControllers;


 import com.market.center.marketcenter.models.serviceViewModels.ArticleDigitaleViewModel;
 import com.market.center.marketcenter.services.ArticleDigitaleService;
 import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

 import static com.market.center.marketcenter.models.entity.enumerationsArticlesCategories
         .DigitaleProdukteEnumeration.ONLINE_VERDIENEN;


@RequestMapping("/view")
@RestController
public class RestOnlineWinController {

    private final ArticleDigitaleService articleDigitaleService;


    public RestOnlineWinController(ArticleDigitaleService articleDigitaleService) {
        this.articleDigitaleService = articleDigitaleService;

    }


    @GetMapping("/all-win-produkte")
    public ResponseEntity<List<ArticleDigitaleViewModel>> findAllOnlineWinProdukte(  ) {




//        return this.articleDigitaleService.findAllWinDigitaleProdukte();


     return    this.articleDigitaleService.findAllCategoryByEnum(ONLINE_VERDIENEN);

    }





}
