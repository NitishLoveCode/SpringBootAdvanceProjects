package com.myLibrary.myLabrary.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@AllArgsConstructor 
@Getter 
@Setter 
public class LoginResponse {

    private String accessToken;
    private String tokenType;
    private long expiresIn;
    private UserResponse user;
    
}



// output will be like

// {
//   "accessToken": "eyJhbGciOiJIUzI1NiJ9...",
//   "tokenType": "Bearer",
//   "expiresIn": 3600000,
//   "user": {
//     "id": 1,
//     "firstName": "John",
//     "lastName": "Doe",
//     "email": "john@example.com",
//     "phone": "1234567890",
//     "status": "ACTIVE",
//     "roles": [
//       "MEMBER"
//     ],
//     "createdAt": "2026-10-06T01:00:00"
//   }
// }