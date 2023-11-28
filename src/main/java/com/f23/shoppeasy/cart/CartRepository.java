package com.f23.shoppeasy.cart;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<CartEntry, Long> {
    /*
    List<CartEntry> findByName(String name);

    @Query("SELECT c FROM Cart c WHERE CONCAT(c.name, c.type) LIKE %?1%")
    List<CartEntry> search(String keyword);
    
    @Override
    public List<CartEntry> findAll();
*/
    
    @Query("SELECT c FROM CartEntry c WHERE c.userId = ?1")
    public List<CartEntry> findAll(long userId);
   
}
