package com.f23.shoppeasy.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService service;

    @GetMapping("/list")
    public String getAllProducts(Model model) {
        model.addAttribute("productList",
                service.getAllProducts());

        return "cart/cart";
    }

    @GetMapping("/add-to-cart")
    public String addItemToCart(Model model) {
        return "cart/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id, Model model) {
        service.deleteProduct(id);
        return "cart/cart";
    }
    
    @PostMapping("/clear-cart")
    public String clearCart(Model model) {
        service.clearCart();
        return "cart/cart";
    }
    
//    @PostMapping("/update/{id}")
//    public String updateCart(@PathVariable long id, @RequestParam("quantity") int quantity, Model model) {
//        service.updateCart(id, quantity);
//        return "cart/cart";
//    }
}
