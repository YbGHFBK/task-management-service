package com.f1zwy.task_service.controller;

import com.f1zwy.task_service.dto.RequestDTO;
import com.f1zwy.task_service.service.CustomUserDetailsService;
import com.f1zwy.task_service.service.JwtService;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public RequestDTO.AuthResponse login(@RequestBody RequestDTO.AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(), request.password())
        );
        UserDetails user = customUserDetailsService.loadUserByUsername(request.username());
        String token = jwtService.generateToken(user);
        return new RequestDTO.AuthResponse(token);
    }
}
