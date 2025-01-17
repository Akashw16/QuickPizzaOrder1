package com.quickpizza.quickpizzaorder.controller;

import com.quickpizza.quickpizzaorder.exception.ResourceNotFoundException;
import com.quickpizza.quickpizzaorder.exception.ValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import com.quickpizza.quickpizzaorder.exception.GlobalExceptionHandler;
import com.quickpizza.quickpizzaorder.exception.ResourceNotFoundException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class GlobalExceptionHandlerTest {

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new TestController())
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    void testResourceNotFoundExceptionHandling() throws Exception {
        mockMvc.perform(get("/test/resource-not-found"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404))
                .andExpect(jsonPath("$.message").value("Test Resource Not Found"));
    }

    @Test
    void testValidationExceptionHandling() throws Exception {
        mockMvc.perform(get("/test/validation-exception"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.message").value("Test Validation Exception"));
    }

    @Test
    void testGenericExceptionHandling() throws Exception {
        mockMvc.perform(get("/test/generic-exception"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.status").value(500))
                .andExpect(jsonPath("$.message").value("An unexpected error occurred"));
    }

    // Inner Test Controller
    private static class TestController {

        @GetMapping("/test/resource-not-found")
        public void throwResourceNotFoundException() {
            throw new ResourceNotFoundException("Test Resource Not Found");
        }

        @GetMapping("/test/validation-exception")
        public void throwValidationException() {
            throw new ValidationException("Test Validation Exception");
        }

        @GetMapping("/test/generic-exception")
        public void throwGenericException() {
            throw new RuntimeException("Test Generic Exception");
        }
    }
}
