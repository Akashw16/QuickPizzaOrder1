package com.quickpizza.quickpizzaorder.dto;

import java.util.List;

public class OrderDTO {
    private String customerName;
    private String deliveryAddress;
    private List<String> items;
    private double totalPrice;
    private String status; // Add this field

    // Getters and Setters
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() { // Add this getter
        return status;
    }

    public void setStatus(String status) { // Add this setter
        this.status = status;
    }
}
