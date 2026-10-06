package com.myLibrary.myLabrary.security;

import java.util.Collection;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.myLibrary.myLabrary.entity.Role;
import com.myLibrary.myLabrary.entity.User;




public class CustomUserDetails implements UserDetails {


    private final User user;

    public  CustomUserDetails(User user){
        this.user = user;
    }

    public User getUser(){
        return  user;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return user.getRoles()
            .stream()
            .map(Role::getName)
            .map(role -> new SimpleGrantedAuthority("ROLE_" + role.name()))
            .toList();
    }

    @Override
    public @Nullable String getPassword() {
        return  user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override 
    public boolean isAccountNonLocked(){
        return user.getStatus() != com.myLibrary.myLabrary.entity.UserStatus.SUSPENDED;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled(){
        return user.getStatus() == com.myLibrary.myLabrary.entity.UserStatus.ACTIVE;
    }
    
}
