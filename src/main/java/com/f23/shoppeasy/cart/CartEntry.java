package com.f23.shoppeasy.cart;

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
 * @author csc340-f23
 */
@Entity
@Table(name = "user_cart_entry")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartEntry {
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
