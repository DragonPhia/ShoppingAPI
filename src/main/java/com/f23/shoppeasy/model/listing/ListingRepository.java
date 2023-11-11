package com.f23.shoppeasy.model.listing;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ListingRepository extends JpaRepository<Listing, Long> {
    public List<Listing> findByName(String name);
    
    @Query("SELECT l FROM Listing l WHERE l.name LIKE ?1")
    public List<Listing> searchByName(String keyword);
    
    @Query("SELECT l FROM Listing l WHERE l.deliveryOrigin LIKE :delivery_origin")
    public List<Listing> searchByOrigin(@Param("delivery_origin") String deliveryOrigin);
}
