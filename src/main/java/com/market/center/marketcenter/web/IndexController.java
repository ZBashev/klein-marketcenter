package com.market.center.marketcenter.web;


import com.market.center.marketcenter.services.CarouselService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final CarouselService carouselService;





    public IndexController(CarouselService carouselService

                           ) {
        this.carouselService = carouselService;


    }


    @GetMapping("/")
    public String index(Model model) {

        String category = "INDEX_PAGE";





        model.addAttribute("firstImg", this.carouselService.firstImage());
        model.addAttribute("secondImg", this.carouselService.secondImage());
        model.addAttribute("thirdImg", this.carouselService.thirdImage());
        model.addAttribute("fourthImg", this.carouselService.fourthImg());


        return "index";
    }


}
