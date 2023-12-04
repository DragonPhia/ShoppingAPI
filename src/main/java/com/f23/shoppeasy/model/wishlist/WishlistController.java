package com.f23.shoppeasy.model.wishlist;

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

    @GetMapping("/list")
    public String getAllProducts(Model model) {
        model.addAttribute("productList",
                service.getAllProducts());

        return "wishlist/my-wishlist";
    }

    @GetMapping("/add-to-wishlist/listing={listingId}&user={userId}")
    public String addToWishlist(Model model, @PathVariable long listingId, @PathVariable long userId) {
        WishlistEntry wishlist = new WishlistEntry();
        wishlist.setItemId(listingId);
        wishlist.setUserId(userId);
        wishlist.setDestination("Placeholder");

        service.addToWishlist(wishlist);

        return "wishlist/my-wishlist";
    }

    @GetMapping("/delete/{id}")
    public String removeItem(@PathVariable long id, Model model) {
        service.removeItem(id);
        return "redirect:/my-wishlist";
    }

    @GetMapping("/empty-wishlist")
    public String clearWishlist(Model model) {
        service.clearWishlist();
        return "redirect:/my-wishlist";
    }

}
