package com.f23.shoppeasy.model.wishlist;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "wishlist_entry")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WishlistEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    private String name;
    private String type;
    private double price;
    private int quantity;
    private long userId;
    private long itemId;
    private String destination;
}
