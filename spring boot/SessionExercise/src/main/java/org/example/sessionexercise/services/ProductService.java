package org.example.sessionexercise.services;

import org.example.sessionexercise.dtos.product.ProductReceiveDto;
import org.example.sessionexercise.dtos.product.ProductResponseDto;
import org.example.sessionexercise.exeptions.NotFoundException;
import org.example.sessionexercise.models.Product;
import org.example.sessionexercise.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    public ProductResponseDto create (ProductReceiveDto productReceiveDto){
        return repository.save(productReceiveDto.dtoToEntity()).toDto();
    }

    public ProductResponseDto get(UUID id){
        return repository.findById(id).orElseThrow(NotFoundException::new).toDto();
    }

    public List<ProductResponseDto> get(){
        return repository.findAll().stream().map(Product::toDto).toList();
    }

    public ProductResponseDto update(UUID id, ProductReceiveDto productReceiveDto){
        Product found = repository.findById(id).orElseThrow(NotFoundException::new);
        Product get = productReceiveDto.dtoToEntity();
        found.set(get);
        return repository.save(found).toDto();
    }

    public void delete (UUID id){
        repository.deleteById(id);
    }

}
