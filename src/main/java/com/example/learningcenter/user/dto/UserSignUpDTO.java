package com.example.learningcenter.user.dto;

import com.example.learningcenter.user.enums.Role;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpDTO {
    private String phoneNumber;
    private String password;
    private Role role;
}
