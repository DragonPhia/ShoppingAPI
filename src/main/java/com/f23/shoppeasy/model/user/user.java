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
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String password;
    private String email;
    private String location;
    
    @Enumerated(EnumType.STRING)
    private UserAccountType accountType;
    
    public user(String name,
            String password,
            String email,
            String location,
            UserAccountType accountType) {
        
        this.name = name;
        this.password = password;
        this.email = email;
        this.location = location;
        this.accountType = accountType;
    }
}
