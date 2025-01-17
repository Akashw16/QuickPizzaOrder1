package com.quickpizza.quickpizzaorder.repository;

import com.quickpizza.quickpizzaorder.model.Cart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CartRepositoryTest {

    @Autowired
    private CartRepository cartRepository;

    private Cart cart;

    @BeforeEach
    void setUp() {
        cart = new Cart();
        cart.setId(1L);
    }

    @Test
    void testSaveCart() {
        cartRepository.save(cart);
        assertNotNull(cartRepository.findById(1L).orElse(null));
    }

    @Test
    void testFindCartById() {
        cartRepository.save(cart);
        assertEquals(cart, cartRepository.findById(1L).orElse(null));
    }
}
