package com.example.nodelogin.user.repository;
import com.example.nodelogin.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    boolean existsByUsername (String username);
    UserEntity findByUsername(String username);

    boolean existsByEmail (String email);
    UserEntity findByEmail (String email);
}