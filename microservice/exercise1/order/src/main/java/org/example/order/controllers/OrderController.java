package org.example.order.controllers;

import org.example.order.models.Customer;
import org.example.order.models.Order;
import org.example.order.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        return Order.builder()
                .id(id)
                .description("Order description")
                .customer(
                        restTemplate.getForObject("http://localhost:8082/customer/{id}", Customer.class, id*100)
                )
                .product(restTemplate.getForObject("http://localhost:8081/product/{id}", Product.class, id*200))
                .build();
    }
}
