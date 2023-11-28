package com.f23.shoppeasy.model.listing;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ListingRepository extends JpaRepository<Listing, Long> {
    public List<Listing> findByName(String name);
    
    @Query("SELECT l FROM Listing l WHERE l.sellerId = :seller_id")
    public List<Listing> getAllBySellerId(@Param("seller_id") long sellerId);
    
    @Query("SELECT l FROM Listing l WHERE l.name LIKE :keyword")
    public List<Listing> searchByName(@Param("keyword") String keyword);
    
    @Query("SELECT l FROM Listing l WHERE l.deliveryOrigin LIKE :delivery_origin")
    public List<Listing> searchByOrigin(@Param("delivery_origin") String deliveryOrigin);
    
    @Modifying
    @Transactional
    @Query("UPDATE Listing l SET l.name = :name, l.price = :price, l.discount = :discount, l.status = :status WHERE l.id = :id")
    public void updateListing(@Param("name") String name,
            @Param("price") double price,
            @Param("discount") double discount,
            @Param("status") ListingStatus status,
            @Param("id") long listingId);
    
}
