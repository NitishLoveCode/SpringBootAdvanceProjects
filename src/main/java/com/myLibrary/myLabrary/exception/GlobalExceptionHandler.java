package com.myLibrary.myLabrary.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice 
public class GlobalExceptionHandler {



    public ResponseEntity<Map<String, Object>> handleDublicateResource(DublicateResourceException ex){
        return build
    }




    private ResponseEntity<Map<String, Object>> buildResponse(
        HttpStatus status,
        String error,
        String message
    ){
        Map<String, Object> response = new HashMap<>();
        
        response.put("timestamp", LocalDateTime.now());
        response.put("status", status.value());
        response.put(error, message);

        return ResponseEntity.status(status).body(response);
    }

    
}
