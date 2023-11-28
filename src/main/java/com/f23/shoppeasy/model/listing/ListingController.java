package com.f23.shoppeasy.model.listing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/listings")
public class ListingController {
    @Autowired
    private ListingService listingService;
    
    @PostMapping("/generate/seller={sellerId}")
    public String generateListing(@PathVariable long sellerId, Listing listing) {
        listing.toggleStatus();
        listingService.generateListing(listing);
        return "redirect:/listings/seller=" + sellerId;
    }
    
    @PostMapping("/edit/generate/id={listingId}")
    public String postEdit(Model model,
            @PathVariable long listingId,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "price", required = false) Double price,
            @RequestParam(value = "discount", required = false) Double discount) {
        
        Listing target = listingService.getbyId(listingId);
        
        if (name == null) {
            name = target.getName();
        }
        
        if (price == null) {
            price = target.getPrice() / target.getDiscount();
        }
        
        if (discount == null) {
            discount = target.getDiscount();
        }
        
        listingService.updateListing(name, price, discount, target.getStatus(), listingId);
        
        return "redirect:/listings/id=" + listingId;
    }
    
    @GetMapping("/edit/id={listingId}")
    public String editListing(Model model, @PathVariable long listingId) {
        Listing target = listingService.getbyId(listingId);
        
        model.addAttribute("listingId", listingId);
        model.addAttribute("listingName", target.getName());
        model.addAttribute("listingPrice", target.getPrice());
        model.addAttribute("listingStatus", target.getStatus().name());
        return "listings/edit";
    }
    
    @GetMapping("/search")
    public String getProducts(Model model, @Param("keyword") String keyword) {
        model.addAttribute("listingList", 
                listingService.getByName(keyword));
        model.addAttribute("keyword", keyword);
        model.addAttribute("defaultUserId", 1);
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
