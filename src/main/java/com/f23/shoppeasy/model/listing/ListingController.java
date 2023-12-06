package com.f23.shoppeasy.model.listing;

import com.f23.shoppeasy.apiManager.ApiRequest;
import com.f23.shoppeasy.model.admin.UserService;
import java.security.Principal;
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
    
    @Autowired
    private UserService userService;
    
    
    @PostMapping("/generate/seller={sellerId}")
    public String generateListing(@PathVariable long sellerId, Listing listing) {
        listing.toggleStatus();
        listingService.generateListing(listing);
        return "redirect:/listings/seller";
    }
    
    @PostMapping("/edit/generate/id={listingId}")
    public String postEdit(Model model,
            @PathVariable long listingId,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "price", required = false) Double price,
            @RequestParam(value = "quantity", required = false) Integer quantity,
            @RequestParam(value = "discount", required = false) Double discount) {
        
        Listing target = listingService.getbyId(listingId);
        
        if (name == null) {
            name = target.getName();
        }
        
        if (price == null) {
            price = target.getPrice() / target.getDiscount();
        }
        
        if (quantity == null) {
            quantity = target.getQuantityAvailable();
        }
        
        if (discount == null) {
            discount = target.getDiscount();
        }
        
        listingService.updateListing(name, price, quantity, discount, target.getStatus(), listingId);
        
        return "redirect:/listings/seller";
    }
    
    @GetMapping("/delete/id={listingId}")
    public String deleteListing(Principal principal, @PathVariable long listingId) {
        Listing target = listingService.getbyId(listingId);
        
        if (userService.getUserByUserName(principal.getName()).getId() == target.getSellerId()) {
            listingService.deleteListing(listingId);
        }
        
        return "redirect:/listings/seller";
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
    
    @GetMapping("/seller")
    public String getCurrentSellerProducts(Principal principal, Model model) {
        long sellerId = userService.getUserByUserName(principal.getName()).getId();
        
        model.addAttribute("sellerListings",
                listingService.getBySellerId(sellerId));
        model.addAttribute("sellerId", sellerId);
        return "seller";
    }
}
