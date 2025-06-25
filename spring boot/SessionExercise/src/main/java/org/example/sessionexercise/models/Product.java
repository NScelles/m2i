package org.example.sessionexercise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sessionexercise.dtos.product.ProductResponseDto;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private double price;


    public void set(Product get) {
        this.setId(get.getId());
        this.setName(get.getName());
        this.setPrice(get.getPrice());
    }

    public ProductResponseDto toDto() {
        return ProductResponseDto.builder()
                .id(getId())
                .name(getName())
                .price(getPrice())
                .build();
    }

}
