package com.myLibrary.myLabrary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myLibrary.myLabrary.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional findByName(String name);
    
}
