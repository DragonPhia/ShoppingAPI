package com.f23.shoppeasy.cart;

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

    @GetMapping("/list")
    public String getAllProducts(Model model) {
        model.addAttribute("productList",
                service.getAllProducts());
        return "cart/cart";
    }

    @GetMapping("/add-to-cart")
    public String addItemToCart(Model model) {
        return "cart/add-to-cart";
    }

    @GetMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable long productId, Model model) {
        service.deleteProduct(productId);
        return "redirect:/cart/list";
    }
}
