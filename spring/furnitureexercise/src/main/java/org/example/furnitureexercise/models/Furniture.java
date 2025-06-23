package org.example.furnitureexercise.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Furniture {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message =  "Le nom ne peut être vide")
    @NotNull(message =  "Le nom ne peut être null")
    @Size(min = 2, max = 50)
    private String name;

    @NotBlank(message =  "La description ne peut être vide")
    @NotNull(message =  "La description ne peut être null")
    @Size(min = 2, max = 500 ,message = "La description doir être inférieure à 500")
    private String description;

    @Min(value = 0, message = "Vous ne pouvez pas avoir un prix inférieure à 0")
    @NotNull(message =  "Le prix ne peut être null")
    private double price;

    @Min(value = 0, message = "Vous ne pouvez pas avoir un stock inférieure à 0")
    @NotNull(message =  "Le stock ne peut être null")
    private int stock;

    @OneToOne(mappedBy = "furniture")
    @Version
    @
    private CardItem cardItem;

}
