package org.example.sessionexercise.controllers;

import jakarta.validation.Valid;
import org.example.sessionexercise.dtos.product.ProductReceiveDto;
import org.example.sessionexercise.dtos.product.ProductResponseDto;
import org.example.sessionexercise.repositories.ProductRepository;
import org.example.sessionexercise.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService productService) {
        this.service = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAll (){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> get (@PathVariable UUID id){
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> create (@Valid @RequestBody ProductReceiveDto productReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(productReceiveDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDto> update (@PathVariable UUID id , @RequestBody ProductReceiveDto productReceiveDto){
        return ResponseEntity.ok(service.update(id,productReceiveDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        service.delete(id);
        return ResponseEntity.ok(String.format("User at id : %s is deleted",id));
    }

}
