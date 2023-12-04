package com.f23.shoppeasy;

import com.f23.shoppeasy.model.admin.UserService;
import com.f23.shoppeasy.model.user.UserAccountType;
import com.f23.shoppeasy.model.user.user;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author samue
 */
@Controller
public class AppController {
    @Autowired
    private UserService userService;
    
    @GetMapping(value = {"", "/", "/index"})
    public String landing() {
        return "index";
    }
    
    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/new-account")
    public String newAccount() {
        return "new-account";
    }
    
    @PostMapping("/create-account")
    public String createNewAccount(
            @RequestParam(value = "email", required = true) String email,
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "accountType", required = true) String accountTypeForm) {
        
        UserAccountType accountType = UserAccountType.valueOf(accountTypeForm);
        user newUser = new user(username, password, email, "Albequerque", accountType);
        userService.saveUser(newUser);
        
        return "redirect:/login";
    }
    
    @GetMapping("/cart")
    public String cart() {
        return "redirect:/cart/list";
    }
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    
    @GetMapping("/about-us")
    public String aboutUs() {
        return "aboutus";
    }
    
    @GetMapping("/admin")
    public String admin() {
        return "redirect:/user/all";
    }

    @GetMapping("/seller")
    public String seller(Principal principal) {
        return "redirect:/listings/seller"; // Hands off control to ListingController
    }
}
