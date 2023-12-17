package com.example.learningcenter.security;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        return security
                .authorizeHttpRequests(
                        registry -> registry
                                .requestMatchers("/","/user/sign-in", "/user/sign-up","/user/password/reset","/css/**").permitAll()
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(
                        loginConfig -> loginConfig
                                .loginPage("/user/sign-in")
                                .defaultSuccessUrl("/",true)
                                .loginProcessingUrl("/user/sign-in")
                                .usernameParameter("phoneNumber")
                                .passwordParameter("password")
                )
                .logout(
                        logoutConfig -> logoutConfig
                                .logoutRequestMatcher(new AntPathRequestMatcher("/user/sign-out"))
                                .logoutSuccessUrl("/user/sign-in")
                ).build();
    }
}
