package com.quickpizza.quickpizzaorder.service;

import com.quickpizza.quickpizzaorder.dto.UserRegistrationDTO;
import com.quickpizza.quickpizzaorder.model.User;
import com.quickpizza.quickpizzaorder.repository.UserRepository;
import com.quickpizza.quickpizzaorder.security.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtUtil jwtUtil;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setId(1L);
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        user.setPassword("password123");
    }

    @Test
    void testRegisterUser() {
        UserRegistrationDTO registrationDTO = new UserRegistrationDTO();
        registrationDTO.setName("John Doe");
        registrationDTO.setEmail("john.doe@example.com");
        registrationDTO.setPassword("password123");

        when(userRepository.save(any(User.class))).thenReturn(user);

        User registeredUser = userService.registerUser(registrationDTO);

        assertNotNull(registeredUser);
        assertEquals("John Doe", registeredUser.getName());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testAuthenticateUser() {
        when(userRepository.findByEmail("john.doe@example.com")).thenReturn(java.util.Optional.of(user));
        when(jwtUtil.generateToken(any())).thenReturn("jwt-token");

        String token = userService.authenticateUser(user);

        assertNotNull(token);
        assertEquals("jwt-token", token);
        verify(jwtUtil, times(1)).generateToken(any());
    }
}
