package org.example.exericisesix.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {
    private int id;
    private String brand;
    private int constructionDate;
    private String color;

    public Car(String brand, int constructionDate, String color) {
        this.brand = brand;
        this.constructionDate = constructionDate;
        this.color = color;
    }
}
