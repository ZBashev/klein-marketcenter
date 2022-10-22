package com.market.center.marketcenter.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {




    public HomeController( ) {

    }

    @GetMapping("/home")
    public String marktplatz(Model model) {


        String category = "HOME_PAGE";



        return "home";
    }


}
