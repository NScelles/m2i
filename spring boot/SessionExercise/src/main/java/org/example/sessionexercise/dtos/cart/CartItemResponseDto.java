package org.example.sessionexercise.dtos.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sessionexercise.dtos.product.ProductResponseDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItemResponseDto {
    private ProductResponseDto product;
    private int quantity;
}
