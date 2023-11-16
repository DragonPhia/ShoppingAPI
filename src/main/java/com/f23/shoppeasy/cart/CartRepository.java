package com.f23.shoppeasy.cart;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    
    List<Cart> findByName(String name);

    @Query("SELECT c FROM Cart c WHERE CONCAT(c.name, c.type) LIKE %?1%")
    List<Cart> search(String keyword);
    
    @Override
    public List<Cart> findAll();
   
}
