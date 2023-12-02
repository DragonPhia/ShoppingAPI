package com.f23.shoppeasy.model.transaction;

import com.f23.shoppeasy.cart.CartEntry;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author JK
 */
@Entity
@Table(name = "transaction_entry")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    private int userId;
    private double total;
}