package com.f23.shoppeasy.admin;

import com.f23.shoppeasy.model.listing.Listing;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author drago
 */

public interface UserListingRepository extends JpaRepository<UserListing, Long> {
    public List<UserListing> findByName(String name);
    
    @Query("SELECT l FROM Listing l WHERE l.id LIKE :keyword")
    public List<UserListing> searchById(@Param("keyword") String keyword);
    
    @Query("SELECT l FROM UserListing l WHERE l.name LIKE :keyword")
    public List<Listing> searchByName(@Param("keyword") String keyword);
}
