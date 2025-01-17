package com.quickpizza.quickpizzaorder.service;

import com.quickpizza.quickpizzaorder.dto.UserRegistrationDTO;
import com.quickpizza.quickpizzaorder.model.User;
import com.quickpizza.quickpizzaorder.repository.UserRepository;
import com.quickpizza.quickpizzaorder.security.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    public User registerUser(UserRegistrationDTO userRegistrationDTO) {
        // Create a new User object from the DTO
        User user = new User();
        user.setName(userRegistrationDTO.getName());
        user.setEmail(userRegistrationDTO.getEmail());
        user.setPassword(userRegistrationDTO.getPassword());
        
        // Save the user to the database (using a repository or service layer)
        user = userRepository.save(user);
        
        return user;
    }
        // Handle user registration logic (e.g., saving to DB)
        // Assign roles, etc.
   

    public String authenticateUser(User user) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return jwtUtil.generateToken(userDetails); // Generate JWT token
    }
}
