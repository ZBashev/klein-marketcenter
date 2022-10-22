package com.market.center.marketcenter.web.digitaleProducte;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/digitale-produkte")
public class DigitaleProdukteController {






    @GetMapping("/blick-digitale-produkte")
    public String viewDigitaleProdukt(Model model) {


        String category = "DIGITALE_PRODUCTE";









        return "digitaleProdukte/digitale-produkte";
    }


}
