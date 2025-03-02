package com.atmmini.atmminisize.repository;

import com.atmmini.atmminisize.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
