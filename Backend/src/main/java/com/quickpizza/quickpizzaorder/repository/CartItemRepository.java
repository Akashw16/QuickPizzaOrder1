package com.quickpizza.quickpizzaorder.repository;

import com.quickpizza.quickpizzaorder.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // Additional queries if needed
}
