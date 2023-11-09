package com.f23.shoppeasy.listing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author samue
 */
@Entity
@Table(name = "listing")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listingId;
    
    private int price;
    private int discount;
    private int sellerId;
    private String name;
    private int status;
    private String deliveryOrigin;
    
    public Listing(int price,
            int sellerId,
            String name,
            String deliveryOrigin) {
        
        this.price = price;
        this.sellerId = sellerId;
        this.name = name;
        this.deliveryOrigin = deliveryOrigin;
        
        this.discount = 0;
        this.status = 0;
    }
}
