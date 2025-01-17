package com.quickpizza.quickpizzaorder.repository;

import com.quickpizza.quickpizzaorder.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long userId); // Find cart by user ID
}
