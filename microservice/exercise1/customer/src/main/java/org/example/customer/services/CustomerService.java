package org.example.customer.services;


import lombok.RequiredArgsConstructor;
import org.example.customer.exeptions.NotFoundException;
import org.example.customer.models.Customer;
import org.example.customer.repositories.CustomerRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public List<Customer> getAllCustomers() {
        return repository.findAll();
    }

    public Customer getCustomerById(UUID id) {

        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Customer createCustomer(Customer Customer) {
        return repository.save(Customer);
    }

    public Customer updateCustomer(UUID id, Customer Customer) {
        return repository.save(Customer);
    }

    public void deleteCustomer(UUID id) {
        repository.deleteById(id);
    }

}
