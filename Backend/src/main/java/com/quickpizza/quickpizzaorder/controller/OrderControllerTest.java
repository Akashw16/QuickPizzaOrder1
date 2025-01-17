package com.quickpizza.quickpizzaorder.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quickpizza.quickpizzaorder.dto.OrderDTO;
import com.quickpizza.quickpizzaorder.model.Order;
import com.quickpizza.quickpizzaorder.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    void testCreateOrder() throws Exception {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCustomerName("John Doe");
        orderDTO.setDeliveryAddress("123 Main Street");
        orderDTO.setItems(Arrays.asList("Pizza Margherita", "Pizza Pepperoni"));
        orderDTO.setTotalPrice(25.50);

        Order order = new Order();
        order.setId(1L);
        order.setCustomerName("John Doe");
        order.setDeliveryAddress("123 Pizza Street");
        order.setStatus("Pending");

        when(orderService.createOrder(any())).thenReturn(order);

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(orderDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerName").value("John Doe"))
                .andExpect(jsonPath("$.deliveryAddress").value("123 Pizza Street"));
    }

    @Test
    void testGetAllOrders() throws Exception {
        Order order = new Order();
        order.setId(1L);
        order.setCustomerName("John Doe");
        order.setDeliveryAddress("123 Pizza Street");

        when(orderService.getAllOrders()).thenReturn(List.of(order));

        mockMvc.perform(get("/api/orders"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].customerName").value("John Doe"));
    }
}
