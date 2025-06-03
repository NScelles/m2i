package org.example.productexercise.dao;

import org.example.productexercise.models.Product;
import org.example.utils.SessionFactorySingleton;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.List;

public class ProductDao extends BaseDao<Product>{
    public ProductDao() {
        super(Product.class);
    }

    public List<Product> getProductsPriceUpTo(double min){
        TypedQuery<Product> query = session.createQuery("select p from Product p where p.price > (:min)", Product.class);
        query.setParameter("min",min);
        return query.getResultList();
    }

    public List<Product> getProductsBuyBetween(LocalDate dateMin,LocalDate dateMax){
        TypedQuery<Product> query = session.createQuery("select p from Product p where p.purchaseDate > (:min) and p.purchaseDate < (:max)", Product.class);
        query.setParameter("min",dateMin);
        query.setParameter("max",dateMax);
        return query.getResultList();
    }

}
