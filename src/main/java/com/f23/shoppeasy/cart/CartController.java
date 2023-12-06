package com.f23.shoppeasy.cart;

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
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService service;
    
    @Autowired
    ListingService listingService;
    
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public String getAllProducts(Model model) {
        model.addAttribute("productList",
                service.getAllProducts());

        return "cart/cart";
    }

    @GetMapping("/add-to-cart/listing={listingId}&user={userId}")
    public String addItemToCart(Model model, @PathVariable long listingId, @PathVariable long userId) {
        Listing source = listingService.getbyId(listingId);
        
        CartEntry cart = new CartEntry();
        cart.setItemId(listingId);
        cart.setUserId(userId);
        cart.setPrice(source.getPrice());
        cart.setName(source.getName());
        cart.setQuantity(1);
        cart.setDestination("Placeholder");
        
        source.setQuantityAvailable(source.getQuantityAvailable() - 1);
        
        if (source.getQuantityAvailable() <= 0) {
            listingService.deleteListing(listingId);
        }

        service.addItemToCart(cart);

        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id, Model model) {
        service.deleteProduct(id);
        return "redirect:/cart";
    }

    @GetMapping("/clear-cart")
    public String clearCart(Model model) {
        service.clearCart();
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(Principal principal, Model model) {
        long userId = userService.getUserByUserName(principal.getName()).getId();
        
        System.out.println(service.checkout(userId));
        model.addAttribute("productList",
                service.checkout(userId));
        return "cart/checkout";
    }

    @GetMapping("/confirmation")
    public String paid(Model model) {
        service.paid(1, 123.43);
        return "cart/confirmation";
    }

//    @PostMapping("/update/{id}")
//    public String updateCart(@PathVariable long id, @RequestParam("quantity") int quantity, Model model) {
//        service.updateCart(id, quantity);
//        return "cart/cart";
//    }
}
