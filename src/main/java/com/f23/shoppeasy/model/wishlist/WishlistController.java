package com.f23.shoppeasy.model.wishlist;

import com.f23.shoppeasy.model.admin.UserService;
import com.f23.shoppeasy.model.listing.Listing;
import com.f23.shoppeasy.model.listing.ListingService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    WishlistService service;
    
    @Autowired
    UserService userService;
    
    @Autowired
    ListingService listingService;
    
    @GetMapping("/all")
    public String getAllProducts(Model model) {
        model.addAttribute("productList",
                service.getAllItems());

        return "wishlist/my-wishlist";
    }

    @GetMapping("/add-to-wishlist/listing={listingId}&user={userId}")
    public String addToWishlist(Model model, @PathVariable long listingId, @PathVariable long userId) {
        Listing source = listingService.getbyId(listingId);
        
        WishlistEntry wishlist = new WishlistEntry();
        wishlist.setItemId(listingId);
        wishlist.setUserId(userId);
        wishlist.setPrice(source.getPrice());
        wishlist.setName(source.getName());
        wishlist.setQuantity(1);
        wishlist.setDestination("Placeholder");
        
        service.addToWishlist(wishlist);

        return "redirect:/wishlist/user-wishlist";
    }

    @GetMapping("/user-wishlist")
    public String getWishlistProducts(Principal principal, Model model) {
        long buyerId = userService.getUserByUserName(principal.getName()).getId();

        model.addAttribute("productList",
                service.getUserItems(buyerId));
        return "wishlist/my-wishlist";
    }

    @GetMapping("/delete/{id}")
    public String removeItem(@PathVariable long id, Model model) {
        service.removeItem(id);
        return "redirect:/wishlist/user-wishlist";
    }

    @GetMapping("/empty-wishlist")
    public String clearWishlist(Model model) {
        service.clearWishlist();
        return "redirect:/wishlist/user-wishlist";
    }

}
