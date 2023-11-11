package com.f23.shoppeasy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author samue
 */
@Controller
public class AppController {
    @GetMapping(value = {"", "/"})
    public String landing() {
        return "index";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    
    @GetMapping("/about-us")
    public String aboutUs() {
        return "aboutus";
    }
    
    // This is here TEMPORARILY until the User implementation is complete.
    // Once it is, /profile should map you straight to the seller page
    // if you are a seller.
    //
    // For the time being, uses a default sellerId (1).
    @GetMapping("/seller={sellerId}")
    public String seller(@PathVariable long sellerId) {
        return "redirect:/listings/seller=" + sellerId; // Hands off control to ListingController
    }
}
