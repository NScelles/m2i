package org.example.tpbank.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Account {
    private  int id;
    private int customerId;
    private Customer customer;
    private List<Operation> operations;
    private Double totalAmount;

    public Account() {

    }

    public Account(int customerId, Customer customer) {
        this.customerId = customerId;
        this.customer = customer;
        operations = new ArrayList<>();
        totalAmount = (double) 0;
    }

    public Account(int customerId, Customer customer, List<Operation> operation, Double totalAmount) {
        this.customerId = customerId;
        this.customer = customer;
        operations = operation;
        this.totalAmount = totalAmount;
    }

    public Account(int id, int customerId, Customer customer, List<Operation> operation, Double totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.customer = customer;
        operations = operation;
        this.totalAmount = totalAmount;
    }
}
