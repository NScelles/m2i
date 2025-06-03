package org.example.heritageexercise.dao;

import org.example.heritageexercise.models.Housing;
import org.example.heritageexercise.models.Product;

import java.util.List;

public class ProductDao extends BaseDao<Product> {

    @Override
    public List<Product> get() {
        return em.createQuery("Select p from Product p", Product.class).getResultList();
    }
}
