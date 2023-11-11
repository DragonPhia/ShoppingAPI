package com.f23.shoppeasy.model.user;

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
 * User database table
 */
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    
    private String name;
    private String email;
    private String location;
    private int age;
    
    @Enumerated(EnumType.STRING)
    private UserAccountType accountType;
    
    public User(String name,
            String email,
            String location,
            int age,
            UserAccountType accountType) {
        
        this.name = name;
        this.email = email;
        this.location = location;
        this.age = age;
        this.accountType = accountType;
    }
}
