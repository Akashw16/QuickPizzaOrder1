package com.quickpizza.quickpizzaorder.service;

import com.quickpizza.quickpizzaorder.model.Cart;
import com.quickpizza.quickpizzaorder.model.Pizza;
import com.quickpizza.quickpizzaorder.repository.CartRepository;
import com.quickpizza.quickpizzaorder.repository.PizzaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CartServiceTest {

    private CartService cartService;
    private CartRepository cartRepository;
    private PizzaRepository pizzaRepository;

    @BeforeEach
    void setUp() {
        cartRepository = mock(CartRepository.class);
        pizzaRepository = mock(PizzaRepository.class);
        cartService = new CartService(cartRepository, pizzaRepository);
    }

    @Test
    void testAddPizzaToCart() {
        Cart cart = new Cart();
        cart.setId(1L);

        Pizza pizza = new Pizza();
        pizza.setId(1L);
        pizza.setName("Margherita");

        when(cartRepository.findById(1L)).thenReturn(Optional.of(cart));
        when(pizzaRepository.findById(1L)).thenReturn(Optional.of(pizza));

        cartService.addPizzaToCart(1L, 1L);

        verify(cartRepository).save(cart);
        assertEquals(1, cart.getItems().size());
    }
}
