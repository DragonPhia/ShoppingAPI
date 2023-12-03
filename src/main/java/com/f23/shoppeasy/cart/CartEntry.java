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

// NOTE
// Did a bunch of editing to all of the Cart files on this branch, feel free to
// keep the bits you like and discard anything you don't. It is incomplete,
// by the by, but it's like 80% of the way to functional. The rest is just
// boilerplate (updating cart html, etc.).

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
