package com.atmmini.atmminisize.service;

import com.atmmini.atmminisize.entity.User;
import com.atmmini.atmminisize.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void register(String username, String password) {
        if (userRepository.findByUsername(username) != null) {
            throw new IllegalArgumentException("Tên người dùng đã tồn tại");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
