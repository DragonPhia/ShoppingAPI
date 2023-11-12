package com.f23.shoppeasy.admin;

import com.f23.shoppeasy.model.listing.Listing;
import com.f23.shoppeasy.model.listing.ListingRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    
    private UserListingRepository repository;
    
    public List<UserListing> getByName(String keyword) {
        if (keyword != null) {
            return repository.searchById(keyword);
        }
        
        return repository.findAll();
    }
    
    public UserListing getbyId(long id) {
        return repository.getReferenceById(id);
    }
    
    public void deleteListing(long id) {
        repository.deleteById(id);
    }
    
    
}