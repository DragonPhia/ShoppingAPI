package com.f23.shoppeasy.model.listing;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
 * @author Samuel Johnson
 */
@Entity
@Table(name = "listings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private double price;
    private double discount;
    private int sellerId;
    private String name;
    private String deliveryOrigin;
    
    @Enumerated(EnumType.STRING)
    private ListingStatus status;
    
    public Listing(int price,
            int sellerId,
            String name,
            String deliveryOrigin) {
        
        this.price = price;
        this.sellerId = sellerId;
        this.name = name;
        this.deliveryOrigin = deliveryOrigin;
        
        this.discount = 0;
    }

    public double getPrice() {
        return this.price * this.discount;
    }
    
    public void setPrice(double price) {
        if (this.status == ListingStatus.AVAILABLE
                || this.status == null) {
            this.price = price;
        }
    }
    
    public void setDiscount(double discount) {
        if (this.status == ListingStatus.AVAILABLE && discount <= 1) {
            this.discount = discount;
        }
    }
    
    public void toggleStatus() {
        if (this.status == null) {
            this.status = ListingStatus.AVAILABLE;
            this.discount = 1;
            return;
        }
        
        switch (this.status) {
            case AVAILABLE -> {
                this.status = ListingStatus.PURCHASED;
            }
            case PURCHASED -> {
                this.status = ListingStatus.SHIPPED;
            }
            case SHIPPED -> {
                this.status = ListingStatus.ARRIVED;
            }
        }
    }
}
