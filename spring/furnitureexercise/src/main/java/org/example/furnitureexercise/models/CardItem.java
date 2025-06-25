package org.example.furnitureexercise.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
public class CardItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
//
//    @Min(1)
//    @NotNull
    private int quantity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "furniture_id")
    private Furniture furniture;

    @Override
    public String toString() {
        return "CardItem{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", furniture=" + furniture +
                '}';
    }
}
