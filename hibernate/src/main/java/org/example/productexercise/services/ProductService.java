package org.example.productexercise.services;

import org.example.productexercise.dao.ProductDao;
import org.example.productexercise.models.Product;

import java.time.LocalDate;
import java.util.List;

public class ProductService {
    ProductDao productDao = new ProductDao();

    public void createProduct(String brand, String ref, LocalDate purchaseDate, double price, int stock) {
        Product product = Product.builder().brand(brand).ref(ref).purchaseDate(purchaseDate).price(price).stock(stock).build();
        productDao.save(product);
    }

    public Product getProduct(int id){
        return productDao.get(id,Product.class);
    }

    public List<Product> getProducts(){
        return productDao.get();
    }

    public void updateProduct(Product product) {
        productDao.save(product);
    }

    public void deleteProduct(Product product) {
        productDao.delete(product);
    }

}
