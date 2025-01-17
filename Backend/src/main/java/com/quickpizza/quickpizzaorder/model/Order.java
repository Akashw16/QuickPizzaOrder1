package com.quickpizza.quickpizzaorder.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Customer name is required")
    @Size(max = 100, message = "Customer name must be less than 100 characters")
    @Column(nullable = false)
    private String customerName;

    @NotBlank(message = "Customer email is required")
    @Email(message = "Invalid email format")
    @Column(nullable = false)
    private String customerEmail;

    @NotBlank(message = "Delivery address is required")
    @Size(max = 255, message = "Delivery address must be less than 255 characters")
    @Column(nullable = false)
    private String deliveryAddress;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @NotEmpty(message = "At least one pizza must be ordered")
    @ElementCollection
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "pizza_name")
    private List<@NotBlank(message = "Pizza name cannot be blank") String> pizzas;

    @NotBlank(message = "Order status is required")
    @Column(nullable = false)
    private String status; // e.g., "Pending", "Completed", "Cancelled"

    // Total price field
    @Column(nullable = false)
    private double totalPrice;

    // Default constructor
    public Order() {
        this.orderDate = LocalDateTime.now(); // Set the order date to the current time
        this.status = "Pending"; // Default status
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public List<String> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<String> pizzas) {
        this.pizzas = pizzas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    // Method to set the pizzas (updated to use List<Pizza> or List<String> based on your design)
    public void setItems(List<String> items) {
        this.pizzas = items;
    }
}
