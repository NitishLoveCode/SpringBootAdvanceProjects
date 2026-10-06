package com.myLibrary.myLabrary.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.myLibrary.myLabrary.entity.User;
import com.myLibrary.myLabrary.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service 
public class CustomUserDetailsService implements UserDetailsService {

    

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    @Override 
    // @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username).orElseThrow(() ->
            new UsernameNotFoundException("User name not found with" + username)
            );
        
        return new CustomUserDetails(user);

    }
    
}
