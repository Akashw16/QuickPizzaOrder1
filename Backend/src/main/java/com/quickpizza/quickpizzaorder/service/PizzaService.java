package com.quickpizza.quickpizzaorder.service;

import com.quickpizza.quickpizzaorder.model.Pizza;
import com.quickpizza.quickpizzaorder.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public Pizza createPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaById(Long id) {
        return pizzaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pizza not found"));
    }

    public Pizza updatePizza(Long id, Pizza pizzaDetails) {
        Pizza pizza = getPizzaById(id);
        pizza.setName(pizzaDetails.getName());
        pizza.setDescription(pizzaDetails.getDescription());
        pizza.setPrice(pizzaDetails.getPrice());
        pizza.setSize(pizzaDetails.getSize());
        return pizzaRepository.save(pizza);
    }

    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }
}
