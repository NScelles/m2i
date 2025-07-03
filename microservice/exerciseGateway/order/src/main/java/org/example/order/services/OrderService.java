package org.example.order.services;


import lombok.RequiredArgsConstructor;

import org.example.order.dtos.OrderResponseDto;
import org.example.order.exeptions.NotFoundException;
import org.example.order.models.Customer;
import org.example.order.models.Order;
import org.example.order.models.Product;
import org.example.order.repositories.OrderRepository;
import org.example.order.util.RestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.example.order.config.AppConfig;

import java.util.List;
import java.util.UUID;

@Service

public class OrderService {

    private final RestTemplate restTemplate;
    private final RestClient<Customer,UUID> customerRestClient;
    private final RestClient<Product,UUID> productRestClient;

    private final OrderRepository repository;

    public OrderService(RestTemplate restTemplate, OrderRepository repository) {
        this.restTemplate = restTemplate;
        this.repository = repository;

        customerRestClient =  new RestClient<>("http://CUSTOMER/customer/",this.restTemplate);
        productRestClient =  new RestClient<>("http://PRODUCT/product/",this.restTemplate);
    }

    public List<OrderResponseDto> getAllOrders() {
        return repository.findAll().stream().map(this::toOrderDto).toList();
    }

    public OrderResponseDto getOrderById(UUID id) {

        return toOrderDto(repository.findById(id).orElseThrow(NotFoundException::new));
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


    public OrderResponseDto toOrderDto(Order order) {
        return OrderResponseDto.builder()
                .id(order.getId())
                .description(order.getDescription())
                .customer(customerRestClient.get(order.getCustomer(),Customer.class))
                .product(productRestClient.get(order.getProduct(),Product.class))
                .build();
    }

}
