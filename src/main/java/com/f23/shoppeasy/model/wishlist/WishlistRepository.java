package com.f23.shoppeasy.model.wishlist;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("WishlistRepository")
public interface WishlistRepository extends JpaRepository<WishlistEntry, Long> {
    
    @Query("SELECT w FROM WishlistEntry w WHERE w.userId = ?1")
    public List<WishlistEntry> findAll(long userId);
   
}
