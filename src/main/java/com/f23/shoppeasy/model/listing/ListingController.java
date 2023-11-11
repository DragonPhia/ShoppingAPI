package com.f23.shoppeasy.model.listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/listings")
public class ListingController {
    @Autowired
    private ListingService listingService;
    
    @PostMapping("/generate/seller={sellerId}")
    public String generateListing(@PathVariable long sellerId, Listing listing) {
        listingService.generateListing(listing);
        return "redirect:/listings/seller=" + sellerId;
    }
    
    @GetMapping("/search")
    public String getProducts(Model model, @Param("keyword") String keyword) {
        model.addAttribute("listingList", 
                listingService.getByName(keyword));
        model.addAttribute("keyword", keyword);
        return "listings/search";
    }
    
    @GetMapping("/seller={sellerId}")
    public String getCurrentSellerProducts(Model model, @PathVariable long sellerId) {
        model.addAttribute("sellerListings",
                listingService.getBySellerId(sellerId));
        model.addAttribute("sellerId", sellerId);
        return "seller";
    }
}
