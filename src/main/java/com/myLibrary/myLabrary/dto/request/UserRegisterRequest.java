package com.myLibrary.myLabrary.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
public class UserRegisterRequest {

    @NotBlank (message = "Frist name is required")
    @Size (max = 50, message = "Frist name should not exceed more then 50 char")
    private String fristName;

    @NotBlank (message = "Last name should not blank")
    @Size (max = 50, message = "Last name shuld not exceed max 50 char")
    private String LastName;

    @NotBlank (message = "Email is required")
    @Email (message = "Invalid email format")
    @Size (max = 150, message = "Email must not exceed 150 char")
    private String email;


    @NotBlank (message = "Password is requird")
    @Size (min=8, max = 100, message = "password must be between 8 to 100 char")
    private String password;

    @Pattern (
        regexp = "^[0-9+()\\-]*$",
        message = "Invalid phone number"
    )
    @Size(max = 20, message = "phone number must not exceed 20 charactors")
    private String phone;
    
}
