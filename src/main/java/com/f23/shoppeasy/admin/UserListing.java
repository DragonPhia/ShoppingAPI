package com.f23.shoppeasy.admin;

/**
 *
 * @author drago
 */
import com.f23.shoppeasy.model.user.UserAccountType;
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
@Table(name = "userlisting")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserListing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String password;
    private String email;
    
    @Enumerated(EnumType.STRING)
    private UserAccountType accountType;
    
    public UserListing(String name,
            String password,
            String email,
            UserAccountType accountType) {
        
        this.name = name;
        this.password = password;
        this.email = email;
        this.accountType = accountType;
    }
}
