package com.quickpizza.quickpizzaorder.repository;

import com.quickpizza.quickpizzaorder.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
