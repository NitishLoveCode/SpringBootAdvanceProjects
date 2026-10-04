package com.myLibrary.myLabrary.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myLibrary.myLabrary.dto.request.UserRegisterRequest;
import com.myLibrary.myLabrary.dto.response.UserResponse;
import com.myLibrary.myLabrary.service.AuthService;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;


@RestController 
@RequestMapping("/api/auth")
public class AuthController {

    
    private  final AuthService authService;

    public AuthController(AuthService authService){
        this.authService = authService;
    }


    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@Valid @RequestBody UserRegisterRequest request){
        UserResponse userResponse = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }


    
}
