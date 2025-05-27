package org.example.exercice1.entity.animal;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private AnimalDiet diet;
    private Date arrivalDate;

    public Animal(String name, int age, AnimalDiet diet, Date arrivalDate) {
        this.name = name;
        this.age = age;
        this.diet = diet;
        this.arrivalDate = arrivalDate;
    }
}