package org.example.productexercise.dao;

import org.example.productexercise.models.Product;

import java.util.List;

public class ProductDao extends BaseDao<Product>{

    @Override
    public List<Product> get() {
        return session.createQuery("select p from Product p", Product.class).getResultList();
    }
}
