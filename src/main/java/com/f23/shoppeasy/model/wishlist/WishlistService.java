package com.f23.shoppeasy.model.wishlist;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository repo;

    public List<WishlistEntry> getAllItems() {
        return repo.findAll();
    }
    
    public List<WishlistEntry> getUserItems(long userId) {
        return repo.findAll(userId);
    }

    public void addToWishlist(WishlistEntry item) {
        repo.save(item);
    }

    public void removeItem(long id) {
        repo.deleteById(id);
    }

    public void clearWishlist() {
        repo.deleteAll();
    }

}
