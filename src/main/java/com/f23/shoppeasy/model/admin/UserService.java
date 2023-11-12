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
    UserRepository repo;

    /**
     * Get all users
     * @return the list of users.
     */
    public List<User> getAllUsers() {
        return repo.findAll();
    }

    /**
     * Find one user by ID.
     * @param id
     * @return the user
     */
    public User getUser(long id) {
        return repo.getUserById(id);
    }

    /**
     * Delete user by ID.
     * @param id 
     */
    public void deleteUser(long id) {
        repo.deleteUserById(id);
    }

    /**
     * Save user entry. 
     * @param user 
     */
    public void saveUser(User user) {
        repo.saveUser(user);
    }

    /**
     * Update existing user.
     * @param user 
     */
    public void updateUser(User user) {
        repo.updateUser(user);
    }
}
