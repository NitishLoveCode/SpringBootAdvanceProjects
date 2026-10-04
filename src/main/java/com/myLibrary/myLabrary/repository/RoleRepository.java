package com.myLibrary.myLabrary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myLibrary.myLabrary.entity.Role;
import com.myLibrary.myLabrary.entity.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleName name);
    
}
