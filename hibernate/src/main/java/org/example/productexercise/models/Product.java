package org.example.productexercise.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String ref;
    private LocalDate purchaseDate;
    private double price;
    private int stock;

    public void update(String brand, String ref, LocalDate purchaseDate, double price, int stock){
        this.brand =brand;
        this.ref = ref;
        this.purchaseDate = purchaseDate;
        this.price= price;
        this.stock=stock;
    }
}
