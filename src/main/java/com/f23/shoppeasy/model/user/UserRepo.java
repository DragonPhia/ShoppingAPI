package com.f23.shoppeasy.model.user;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<user, Long> {
    Optional<user> findByName(String name);
}
