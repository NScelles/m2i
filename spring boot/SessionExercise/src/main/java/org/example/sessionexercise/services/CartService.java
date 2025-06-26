package org.example.sessionexercise.services;

import org.example.sessionexercise.dtos.cart.CartItemResponseDto;
import org.example.sessionexercise.dtos.product.ProductResponseDto;
import org.example.sessionexercise.exeptions.NotFoundException;
import org.example.sessionexercise.models.CartItem;
import org.example.sessionexercise.models.Product;
import org.example.sessionexercise.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService {
    private final ProductRepository productRepository;
    private List<CartItem> cart;

    @Autowired
    public CartService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void setSession(List<CartItem> cartSesion) {
        this.cart = Objects.requireNonNullElseGet(cartSesion, ArrayList::new);
    }

    public List<CartItemResponseDto> getCart() {

        List<Product> products = productRepository.findProductsByIds(cart.stream().map(CartItem::getIdProduct).toList());
        return cart.stream().map(cartItem -> cartItem.toDto(products.stream().filter(p -> p.getId().equals(cartItem.getIdProduct())).findFirst().get())).toList();
    }

    public List<CartItem> addProduct(UUID id) {
        if(cart.stream().noneMatch(cartItem -> cartItem.getIdProduct().equals(id)))
            cart.add( CartItem.builder()
                .idProduct(productRepository.findById(id).orElseThrow(NotFoundException::new).getId())
                .quantity(1).build());
        else
            cart.stream()
                    .filter(cartItem -> cartItem.getIdProduct().equals(id))
                    .findFirst()
                    .ifPresent(cartItem -> {cartItem.setQuantity(cartItem.getQuantity() + 1);});
        return cart;
    }

    public List<CartItem> removeProduct(UUID id) {
        CartItem item;
        if(cart.stream().anyMatch(cartItem -> cartItem.getIdProduct().equals(id))) {
            item = cart.stream().filter(cartItem -> cartItem.getIdProduct().equals(id)).findFirst().get();
            if (item.getQuantity() > 1)
                cart.stream().filter(cartItem -> cartItem.getIdProduct().equals(id)).findFirst().get().setQuantity(item.getQuantity() - 1);
            else
                cart.remove(item);
        }
        else
                throw new NotFoundException();
        return cart;
    }

    public double buyProduct() {
        double totalPrice = 0;
        List<Product> products = productRepository.findProductsByIds(cart.stream().map(CartItem::getIdProduct).toList());
        if(!cart.isEmpty()){
            for(CartItem item : cart)
                totalPrice += products.stream().filter(product -> product.getId().equals(item.getIdProduct())).findFirst().get().getPrice() * item.getQuantity();
        }
        cart.clear();
        return totalPrice;
    }

}
