package org.example.product.controllers;

import org.example.product.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable int id) {
        return Product.builder()
                .id(id)
                .name("le claquagou de Salimou")
                .price(3.14)
                .build();
    }

}
