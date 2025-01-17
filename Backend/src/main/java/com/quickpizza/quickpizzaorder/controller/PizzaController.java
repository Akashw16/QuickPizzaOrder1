package com.quickpizza.quickpizzaorder.controller;

import com.quickpizza.quickpizzaorder.model.Pizza;
import com.quickpizza.quickpizzaorder.service.PizzaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public ResponseEntity<Pizza> createPizza(@Valid @RequestBody Pizza pizza) {
        Pizza createdPizza = pizzaService.createPizza(pizza);
        return ResponseEntity.ok(createdPizza);
    }

    @GetMapping
    public List<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) {
        Pizza pizza = pizzaService.getPizzaById(id);
        return ResponseEntity.ok(pizza);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pizza> updatePizza(@PathVariable Long id, @Valid @RequestBody Pizza pizza) {
        Pizza updatedPizza = pizzaService.updatePizza(id, pizza);
        return ResponseEntity.ok(updatedPizza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Long id) {
        pizzaService.deletePizza(id);
        return ResponseEntity.noContent().build();
    }
}
