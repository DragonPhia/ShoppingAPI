package com.f23.shoppeasy.model.admin;

import com.f23.shoppeasy.model.user.user;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author drago
 */
@Service
public class UserService {

    @Autowired
    UserRepository repository;
    
    @Autowired
    UserRepositorySecurity repositorySecurity;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User getUser(long id) {
        return repository.getUserById(id);
    }

    public void deleteUser(long id) {
        repository.deleteUserById(id);
    }

    public void saveUser(user user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.saveUser(user);
    }
    
    public User getUserByUserName(String userName) {
        return repositorySecurity.findByUserName(userName).orElseThrow(()
                -> new UsernameNotFoundException(userName + "not found"));
    }
    
    public void updateUser(User user) {
        User existing = repositorySecurity.getReferenceById(user.getId());
        if (user.getUserName() != null) {
            existing.setUserName(user.getUserName());
        }
        if (user.getPassword() != null) {
            existing.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        if (user.getEmail() != null) {
            existing.setEmail(user.getEmail());
        }
        if (user.getRole() != null) {
            existing.setRole(user.getRole());
        }
        repositorySecurity.save(existing);
    }
    
}
