package com.f23.shoppeasy.cart;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository repo;

    
    public List<Cart> getAllProducts() {
        return repo.findAll();
    }

    public void deleteProduct(long productId) {
        repo.deleteById(productId);
    }
    
    
    public void addItemToCart(Cart cartItem) {
        // Check if the item is already in the cart
        Optional<Cart> existingItem = repo.findById(cartItem.getId());

        if (existingItem.isPresent()) {
            // Item is already in the cart, update the quantity
            Cart currentItem = existingItem.get();
            currentItem.setQuantity(currentItem.getQuantity() + cartItem.getQuantity());
            repo.save(currentItem);
        } else {
            // Item is not in the cart, add it
            repo.save(cartItem);
        }
    }

    public void updateCartItemQuantity(long itemId, int newQuantity) {
        Optional<Cart> existingItem = repo.findById(itemId);

        existingItem.ifPresent(cartItem -> {
            cartItem.setQuantity(newQuantity);
            repo.save(cartItem);
        });
    }

    public double calculateTotalPrice() {
        List<Cart> cartItems = repo.findAll();
        double totalPrice = 0.0;

        for (Cart cartItem : cartItems) {
            totalPrice += cartItem.getPrice() * cartItem.getQuantity();
        }

        return totalPrice;
    }
}
