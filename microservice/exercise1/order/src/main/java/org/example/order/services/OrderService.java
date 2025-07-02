package org.example.order.services;


import lombok.RequiredArgsConstructor;

import org.example.order.exeptions.NotFoundException;
import org.example.order.models.Order;
import org.example.order.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;

    public List<Order> getAllOrders() {
        return repository.findAll();
    }

    public Order getOrderById(UUID id) {

        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Order createOrder(Order Order) {
        return repository.save(Order);
    }

    public Order updateOrder(UUID id, Order Order) {
        return repository.save(Order);
    }

    public void deleteOrder(UUID id) {
        repository.deleteById(id);
    }

}
