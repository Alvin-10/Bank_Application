package com.alvin.project.userservice.controller;

import com.alvin.project.userservice.dto.LoginDTO;
import com.alvin.project.userservice.dto.UserDTO;
import com.alvin.project.userservice.service.AuthService;
import com.alvin.project.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Valid UserDTO userDTO) {
        userService.registerUser(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO loginDTO) {
        String token = authService.authenticate(loginDTO);
        return ResponseEntity.ok(token);
    }
}