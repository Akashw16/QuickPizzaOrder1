package com.quickpizza.quickpizzaorder.service;

import com.quickpizza.quickpizzaorder.model.Order;
import com.quickpizza.quickpizzaorder.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    private Order order;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        order = new Order();
        order.setId(1L);
        order.setCustomerName("John Doe");
        order.setDeliveryAddress("123 Pizza Street");
        order.setStatus("Pending");
    }

    @Test
    void testCreateOrder() {
        when(orderRepository.save(any(Order.class))).thenReturn(order);

        Order createdOrder = orderService.createOrder(order);

        assertNotNull(createdOrder);
        assertEquals("John Doe", createdOrder.getCustomerName());
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    void testGetOrderById() {
        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        Order foundOrder = orderService.getOrderById(1L);

        assertNotNull(foundOrder);
        assertEquals(1L, foundOrder.getId());
    }

    @Test
    void testGetOrderByIdNotFound() {
        when(orderRepository.findById(1L)).thenReturn(Optional.empty());

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            orderService.getOrderById(1L);
        });

        assertEquals("Order not found with id 1", exception.getMessage());
    }
}
