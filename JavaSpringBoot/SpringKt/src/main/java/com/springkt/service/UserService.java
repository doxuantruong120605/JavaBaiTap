package com.springkt.service;

import com.springkt.entity.User;
import com.springkt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Create
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Read
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(userDetails.getName());
        user.setAge(userDetails.getAge());
        user.setSalary(userDetails.getSalary());
        return userRepository.save(user);
    }

    // Delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Search
    public List<User> searchUsers(String name) {
        return userRepository.findByNameContainingIgnoreCase(name);
    }


}
