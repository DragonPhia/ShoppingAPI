package com.f23.shoppeasy.model.admin;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author csc340-f23
 */
public interface UserRepositorySecurity extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String username);
}
