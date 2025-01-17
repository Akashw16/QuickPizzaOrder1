package com.quickpizza.quickpizzaorder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Topping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Topping name is required")
    private String name;

    private double price;

    // Getters and Setters
}
