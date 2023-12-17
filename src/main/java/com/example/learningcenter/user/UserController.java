package com.example.learningcenter.user;

import com.example.learningcenter.user.dto.ForgotPasswordDTO;
import com.example.learningcenter.user.dto.UserSignUpDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final ModelMapper modelMapper = new ModelMapper();

    @GetMapping("/sign-in")
    public String goSignIn() {
        return "security/sign-in";
    }

    @GetMapping("/sign-up")
    public String goSignUp() {
        return "security/sign-up";
    }

    @GetMapping("/password/reset")
    public String goForgotPassword() {
        return "security/forgot-password";
    }

    @PostMapping("/sign-up")
    public String createUser(@ModelAttribute UserSignUpDTO userSignUpDTO) {
        userService.create(userSignUpDTO);
        return "redirect:/index";
    }

    @PostMapping("/password/reset")
    public String forgotPassword(@ModelAttribute ForgotPasswordDTO forgotPasswordDTO) {
        userService.updatePassword(forgotPasswordDTO);
        return "redirect:/index";
    }

}
