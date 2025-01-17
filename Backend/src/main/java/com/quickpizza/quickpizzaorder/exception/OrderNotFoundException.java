package com.quickpizza.quickpizzaorder.exception;

// Step 1: Custom Exceptions
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}