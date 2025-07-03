package org.example.product.services;

import exeptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.product.models.Product;
import org.example.product.repositories.ProuctRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProuctRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(UUID id) {

        return repository.findById(id).orElseThrow(NotFoundException::new);
    }

    public Product createProduct(Product product) {
        return repository.save(product);
    }

    public Product updateProduct(UUID id, Product product) {
        return repository.save(product);
    }

    public void deleteProduct(UUID id) {
        repository.deleteById(id);
    }

}
