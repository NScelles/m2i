package org.example.sessionexercise.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.sessionexercise.dtos.cart.CartItemResponseDto;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {
    private UUID idProduct;
    private int quantity;

    public CartItemResponseDto toDto(Product product) {
        return CartItemResponseDto.builder()
                .product(product.toDto())
                .quantity(quantity)
                .build();
    }
}
