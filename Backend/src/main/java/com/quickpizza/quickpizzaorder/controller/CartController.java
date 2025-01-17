package com.quickpizza.quickpizzaorder.controller;

import com.quickpizza.quickpizzaorder.model.Cart;
import com.quickpizza.quickpizzaorder.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/{cartId}/add/{pizzaId}")
    public ResponseEntity<Cart> addPizzaToCart(@PathVariable Long cartId, @PathVariable Long pizzaId) {
        Cart updatedCart = cartService.addPizzaToCart(cartId, pizzaId);
        return ResponseEntity.ok(updatedCart);
    }
}
