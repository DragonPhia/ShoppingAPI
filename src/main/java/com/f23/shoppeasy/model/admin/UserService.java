package com.f23.shoppeasy.model.admin;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author drago
 */
@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUser(long id) {
        return repository.getUserById(id);
    }

    public void deleteUser(long id) {
        repository.deleteUserById(id);
    }

    public void saveUser(User user) {
        repository.saveUser(user);
    }
    
}
