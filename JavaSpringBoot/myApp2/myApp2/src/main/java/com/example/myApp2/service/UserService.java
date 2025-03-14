package com.example.myApp2.service;

import com.example.myApp2.model.User;
import com.example.myApp2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int id) {
        return userRepository.findById(id);
    }

    public User addUser (User user) {
        return  userRepository.save(user);
    }

    public User updateUser (User user) {
        return userRepository.save(user);
    }

    public void deleteUser (int id) {
        userRepository.deleteById(id);
    }

}
