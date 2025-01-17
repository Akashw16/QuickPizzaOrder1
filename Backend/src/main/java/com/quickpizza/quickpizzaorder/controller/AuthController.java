package com.quickpizza.quickpizzaorder.controller;

import com.quickpizza.quickpizzaorder.dto.UserRegistrationDTO;
import com.quickpizza.quickpizzaorder.model.User;
import com.quickpizza.quickpizzaorder.security.JwtUtil;
import com.quickpizza.quickpizzaorder.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        User registeredUser = userService.registerUser(userRegistrationDTO);
        return ResponseEntity.ok("User registered successfully with ID: " + registeredUser.getId());
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        String token = userService.authenticateUser(user);
        return ResponseEntity.ok("Bearer " + token);
    }
}
