package com.quickpizza.quickpizzaorder.service;

import com.quickpizza.quickpizzaorder.model.Cart;
import com.quickpizza.quickpizzaorder.model.Pizza;
import com.quickpizza.quickpizzaorder.repository.CartRepository;
import com.quickpizza.quickpizzaorder.repository.PizzaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class CartService {

    private final CartRepository cartRepository;
    private final PizzaRepository pizzaRepository;

    public CartService(CartRepository cartRepository, PizzaRepository pizzaRepository) {
        this.cartRepository = cartRepository;
        this.pizzaRepository = pizzaRepository;
    }

    public Cart addPizzaToCart(long cartId, long pizzaId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found"));

        Pizza pizza = pizzaRepository.findById(pizzaId)
                .orElseThrow(() -> new IllegalArgumentException("Pizza not found"));

        cart.addItem(pizza, 1); // Default quantity is 1
        return cartRepository.save(cart);
    }
}
