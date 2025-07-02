package org.example.customer.controllers;

import org.example.customer.models.Customer;
import org.example.customer.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    private CustomerService service;
    
    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getCustomerById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(service.getAllCustomers());
    }


    @PostMapping()
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer Customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCustomer(Customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable UUID id, @RequestBody Customer Customer) {
        return ResponseEntity.ok(service.updateCustomer(id, Customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable UUID id) {
        service.deleteCustomer(id);
        return ResponseEntity.ok(id + " is deleted successfully");
    }
}
