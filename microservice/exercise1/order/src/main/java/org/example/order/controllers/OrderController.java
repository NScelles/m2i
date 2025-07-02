package org.example.order.controllers;

import org.example.order.models.Customer;
import org.example.order.models.Order;
import org.example.order.models.Product;
import org.example.order.util.RestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final RestTemplate restTemplate = new RestTemplate();
    private final RestClient<Customer,Integer> customerRestClient = new RestClient<>("http://localhost:8082/customer/");
    private final RestClient<Product,Integer> productRestClient = new RestClient<>("http://localhost:8081/product/");

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable UUID id) {
        return Order.builder()
                .id(id)
                .description("Order description")
                .customer(customerRestClient.get(100,Customer.class).getId())
                .product(productRestClient.get(200,Product.class).getId())
                .build();
    }
}
