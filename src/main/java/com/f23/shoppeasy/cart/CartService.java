package com.f23.shoppeasy.cart;

import com.f23.shoppeasy.model.transaction.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository repo;
    
    @Autowired
    private TransactionRepository transactionRepo;

    public CartEntry getCart() {
        return new CartEntry();
    }

    public List<CartEntry> getAllProducts() {
        return repo.findAll();
    }

    public void deleteProduct(long id) {
        repo.deleteById(id);
    }

    public void clearCart() {
        repo.deleteAll();
    }

    public List<CartEntry> checkout(long userId) {
        return repo.findAll(userId);
    }

    public void paid(long userId, double total) {
        transactionRepo.save(userId, total);
    }    
    
    public void addItemToCart(CartEntry cartItem) {
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
    void saveProduct(CartEntry cartItem) {
        repo.save(cartItem);
    }
}
