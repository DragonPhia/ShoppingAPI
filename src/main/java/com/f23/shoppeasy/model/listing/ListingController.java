package com.f23.shoppeasy.model.listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listings")
public class ListingController {
    @Autowired
    private ListingService listingService;
    
    @GetMapping("/search")
    public String getProducts(Model model, @Param("keyword") String keyword) {
        model.addAttribute("listingList", 
                listingService.getByName(keyword));
        model.addAttribute("keyword", keyword);
        return "listings/search";
    }
}
