package com.myLibrary.myLabrary.service;

import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myLibrary.myLabrary.dto.request.UserRegisterRequest;
import com.myLibrary.myLabrary.dto.response.UserResponse;
import com.myLibrary.myLabrary.entity.Role;
import com.myLibrary.myLabrary.entity.RoleName;
import com.myLibrary.myLabrary.entity.User;
import com.myLibrary.myLabrary.exception.DublicateResourceException;
import com.myLibrary.myLabrary.exception.ResourceNotFoundException;
import com.myLibrary.myLabrary.repository.RoleRepository;
import com.myLibrary.myLabrary.repository.UserRepository;

@Service 
public class AuthService {



    private final UserRepository userRepository;

    private  final RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;


    public AuthService(
        UserRepository userRepository,
        RoleRepository roleRepository,
        PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    


    
    public UserResponse register(UserRegisterRequest request){
        String email = request.getEmail().trim().toLowerCase();

        if(userRepository.existsByEmail(email)){
            throw new DublicateResourceException("Email is already registerd");
        }

        Role mamberRole = roleRepository.findByName(RoleName.MEMBER)
        .orElseThrow(() ->
            new ResourceNotFoundException("Mamber role not found")
        );

        User user = new User();


        // Password encoder
        String encodePassword = passwordEncoder.encode(request.getPassword());

        user.setFristName(request.getFristName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(encodePassword);
        user.setPhone(request.getPhone());
        user.setRoles(Set.of(mamberRole));

        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);

    }


    private UserResponse mapToResponse(User user){
        Set<RoleName> roles = user.getRoles()
            .stream()
            .map(Role::getName)
            .collect(Collectors.toSet());
    
        return new UserResponse(
            user.getId(),
            user.getFristName(),
            user.getLastName(),
            user.getEmail(),
            user.getPhone(),
            user.getStatus(),
            roles,
            user.getCreateAt()
        );
    }



    
}
