package org.example.productexercise.services;

import org.example.productexercise.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final Map<UUID, Product> products;
    public ProductService(){
        products = new HashMap<>();
        Product product1 = Product.builder().id(UUID.randomUUID()).name("Product Name 1").category("Category 1").price(200).build();
        Product product2 = Product.builder().id(UUID.randomUUID()).name("Product Name 2").category("Category 2").price(500).build();
        Product product3 = Product.builder().id(UUID.randomUUID()).name("Product Name 3").category("Category 1").price(777).build();
        products.put(product1.getId(), product1);
        products.put(product2.getId(), product2);
        products.put(product3.getId(), product3);
    }

    public List<Product> getProducts() {
        return products.values().stream().toList();
    }

    public Product getProduct(UUID id) {
        return products.get(id);
    }

    public List<Product> getProductsByCategory(List<Product> productList, String category) {
        //List<Product> productss = products.values().stream().max().toList();
        return productList.stream().filter(p -> p.getCategory().equals(category)).toList();
    }

    public List<Product> getProductsByPriceMax(List<Product> productList,double priceMax) {
        return productList.stream().filter(p -> p.getPrice() < priceMax).toList();
    }

}
