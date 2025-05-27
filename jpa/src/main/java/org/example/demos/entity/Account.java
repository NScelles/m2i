package org.example.demos.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;
    private String customerName;
    private String accountNumber;

    public Account(double amount, String customerName, String accountNumber) {
        this.amount = amount;
        this.customerName = customerName;
        this.accountNumber = accountNumber;
    }
}
