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

    public Product addProduct(Product product) {
        product.setId(UUID.randomUUID());
        products.put(product.getId(), product);
        return product;
    }
    public Product updateProduct(Product product) {
        products.replace(product.getId(), product);
        return product;
    }

    public List<Product> getProductsByCategory(List<Product> productList, String category) {
        if (category != null && !category.isEmpty()) {
          productList =  productList.stream().filter(p -> p.getCategory().equals(category)).toList();
        }
        return productList;
    }

    public List<Product> getProductsByPriceMax(List<Product> productList,String priceMax) {
        if (priceMax != null && !priceMax.isEmpty()) {
           productList = productList.stream().filter(p -> p.getPrice() < Double.parseDouble(priceMax)).toList();
        }
        return productList;
    }
}
