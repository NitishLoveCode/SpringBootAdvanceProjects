package com.myLibrary.myLabrary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myLibrary.myLabrary.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existByEmail(String email);
    
}
