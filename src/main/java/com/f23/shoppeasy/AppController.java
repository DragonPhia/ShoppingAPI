package com.f23.shoppeasy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
