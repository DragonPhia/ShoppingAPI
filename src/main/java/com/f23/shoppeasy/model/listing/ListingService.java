package com.f23.shoppeasy.model.listing;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListingService {
    @Autowired
    private ListingRepository repository;
    
    public List<Listing> getAll() {
        return repository.findAll();
    }
    
    public List<Listing> getByName(String keyword) {
        if (keyword != null) {
            return repository.searchByName(keyword);
        }
        
        return repository.findAll();
    }
    
    public List<Listing> getByOrigin(String keyword) {
        if (keyword != null) {
            return repository.searchByOrigin(keyword);
        }
        
        return repository.findAll();
    }
    
    public List<Listing> getBySellerId(long sellerId) {
        return repository.getAllBySellerId(sellerId);
    }
    
    public Listing getbyId(long id) {
        return repository.getReferenceById(id);
    }
    
    public void deleteListing(long id) {
        repository.deleteById(id);
    }
    
    public void generateListing(Listing listing) {
        repository.save(listing);
    }
    
    public void updateListing(String name, double price, double discount, ListingStatus status, long listingId) {
        repository.updateListing(name, price, discount, status, listingId);
    }
}
