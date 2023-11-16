package com.f23.shoppeasy.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    
    @Autowired
    private CartRepository repo;

    public Cart getCart() {
        return new Cart();
    }

    public List<Cart> getAllProducts() {
        return repo.findAll();
    }

    public void deleteProduct(long id) {
        repo.deleteById(id);
    }
    
    public void clearCart() {
        repo.deleteAll();
    }

    public void addItemToCart(Cart cartItem) {
            repo.save(cartItem);
        }

//    public void updateCart(long productId, int newQuantity) {
//        Optional<Cart> existingItem = repo.findById(productId);
//        existingItem.ifPresent(cartItem -> {
//            cartItem.setQuantity(newQuantity);
//            repo.save(cartItem);
//        });
//    }
//
//    public double calculateTotalPrice() {
//        List<Cart> cartItems = repo.findAll();
//        double totalPrice = 0.0;
//
//        for (Cart cartItem : cartItems) {
//            totalPrice += cartItem.getPrice() * cartItem.getQuantity();
//        }
//
//        return totalPrice;
//    }
    
    // Save after quantity changes
    void saveProduct(Cart cartItem) {
        repo.save(cartItem);
    }
}
