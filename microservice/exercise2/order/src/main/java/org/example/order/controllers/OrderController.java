package org.example.order.controllers;

import org.example.order.dtos.OrderResponseDto;
import org.example.order.models.Customer;
import org.example.order.models.Order;
import org.example.order.models.Product;
import org.example.order.services.OrderService;
import org.example.order.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService service;

    @Autowired
    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getOrderById(id));
    }

    @GetMapping()
    public ResponseEntity<List<OrderResponseDto>> getAllOrder() {
        return ResponseEntity.ok(service.getAllOrders());
    }


    @PostMapping()
    public ResponseEntity<Order> saveOrder(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createOrder(order));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable UUID id, @RequestBody Order order) {
        return ResponseEntity.ok(service.updateOrder(id, order));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable UUID id) {
        service.deleteOrder(id);
        return ResponseEntity.ok(id + " is deleted successfully");
    }
}
