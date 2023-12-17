package com.example.learningcenter.authorization;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/test")
public class AuthorizationTestController {
    @PreAuthorize(value = "hasAuthority('ADMIN')")
    @GetMapping("/admin")
    public String getAdmin(){
        return "admin";
    }
    @GetMapping("/student")
    public String getStudent(){
        return "student";
    }
    @GetMapping("/mentor")
    public String getMentor(){
        return "mentor";
    }
}
