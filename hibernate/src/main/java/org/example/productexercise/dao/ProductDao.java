package org.example.productexercise.dao;

import org.example.productexercise.models.Article;
import org.example.productexercise.models.Product;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<Article> getArticlesStockLowerThan(int stock){
        TypedQuery<Product> query = session.createQuery("select p from Product p where p.stock < :stock", Product.class);
        query.setParameter("stock",stock);
        List<Product> products = query.getResultList();
        List<Article> articles = new ArrayList<>();
        for (Product product:products)
            articles.add(Article.builder().id(product.getId()).ref(product.getRef()).build());
        return articles;
    }

    public List<Product> getStocksByBrand(String brand){
        TypedQuery<Product> query = session.createQuery("select p from Product p where p.brand = :brand", Product.class);
        query.setParameter("brand",brand);
        return query.getResultList();
    }

    public List<Product> getProductsByBrand(String brand){
        TypedQuery<Product> query = session.createQuery("select p from Product p where p.brand = :brand", Product.class);
        query.setParameter("brand",brand);
        return query.getResultList();
    }

    public Double getAvgPrice(){
        return session.createQuery("select avg(price) from Product p", Double.class).uniqueResult();
    }

    public boolean deleteByBrand(String brand){
        session.beginTransaction();
        Query query = session.createQuery("delete Product p where p.brand=:brand");
        query.setParameter("brand",brand);
        int success = query.executeUpdate();
        session.getTransaction().commit();
        return success>0;
    }

    public List<Product> getMostRatingProducts(double avg) {
        TypedQuery<Product> query = session.createQuery("select c.product from Comment c group by c.product having avg(c.rating) >= :avg", Product.class);
        query.setParameter("avg",avg);
        return query.getResultList();
    }

}
