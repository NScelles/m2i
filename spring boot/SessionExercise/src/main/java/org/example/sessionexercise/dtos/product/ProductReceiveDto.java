package org.example.sessionexercise.dtos.product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sessionexercise.models.Product;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductReceiveDto {

    @NotEmpty
    @Size(min = 2, max = 50)
    @NotNull
    private String name;
    @Min(0)
    @NotNull
    private double price;

    public Product dtoToEntity(){
        return Product.builder()
                .name(getName())
                .price(getPrice())
                .build();
    }


}
