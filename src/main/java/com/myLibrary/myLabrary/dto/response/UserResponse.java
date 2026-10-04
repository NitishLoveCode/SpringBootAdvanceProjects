package com.myLibrary.myLabrary.dto.response;

import java.time.LocalDateTime;
import java.util.Set;

import com.myLibrary.myLabrary.entity.RoleName;
import com.myLibrary.myLabrary.entity.UserStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
public class UserResponse {
    
    private Long id;
    private String fristName;
    private String lastName;
    private  String email;
    private String phone;
    private UserStatus status;
    private  Set<RoleName> roles;
    private LocalDateTime createdAt;

}
