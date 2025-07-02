package org.example.customer.controllers;

import org.example.customer.models.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return Customer.builder()
                .id(id)
                .lastName("Salimou le musculou")
                .build();
    }
}
