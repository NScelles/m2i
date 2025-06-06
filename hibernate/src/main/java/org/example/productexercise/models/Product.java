package org.example.productexercise.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @OneToMany(mappedBy = "product",cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Image> images;

    @OneToMany(mappedBy = "product",cascade = {CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Comment> comments;

    public void update(String brand, String ref, LocalDate purchaseDate, double price, int stock){
        this.brand =brand;
        this.ref = ref;
        this.purchaseDate = purchaseDate;
        this.price= price;
        this.stock=stock;
    }
}
