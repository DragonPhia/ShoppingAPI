package com.f23.shoppeasy.admin;

import com.f23.shoppeasy.model.listing.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author drago
 */
@Controller
@RequestMapping("/userlistings")
public class UserController {
    
    @Autowired
    private UserService listingService;
    
    
    @DeleteMapping("userlisting/id={id}") 
    public String deleteFile(@PathVariable("id") long id) { 
        
        listingService.deleteListing(id);
        return "File deleted " + id; 
 }
    
    
}
