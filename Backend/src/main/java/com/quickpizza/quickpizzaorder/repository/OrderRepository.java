package com.quickpizza.quickpizzaorder.repository;

import com.quickpizza.quickpizzaorder.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Custom queries if needed
}
