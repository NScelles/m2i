package org.example.tpproduct.services;

import org.example.tpproduct.dao.SellingDao;
import org.example.tpproduct.dao.CustomerDao;
import org.example.tpproduct.dao.ArticleDao;
import org.example.tpproduct.models.Customer;
import org.example.tpproduct.models.articles.Article;
import org.example.tpproduct.models.articles.Electronic;
import org.example.tpproduct.models.articles.Food;
import org.example.tpproduct.models.articles.clothing.Categories;
import org.example.tpproduct.models.articles.clothing.Clothes;
import org.example.tpproduct.models.selling.Selling;
import org.example.tpproduct.models.selling.SellingStatus;

import java.time.LocalDate;
import java.util.List;

public class StoreService {
    ArticleDao articleDao = new ArticleDao();
    CustomerDao customerDao = new CustomerDao();
    SellingDao sellingDao = new SellingDao();


    /// CRUD Article

    public Food createArticle(String description, double price, int stock, LocalDate restockDate, LocalDate expiryDate){
        Food food = Food.builder().description(description).price(price).stock(stock).restockDate(restockDate).expiryDate(expiryDate).build();
        articleDao.save(food);
        return food;
    }

    public Clothes createArticle(String description, double price, int stock, LocalDate restockDate, int size, Categories category){
        Clothes clothes = Clothes.builder().description(description).price(price).stock(stock).restockDate(restockDate).size(size).category(category).build();
        articleDao.save(clothes);
        return clothes;
    }

    public Electronic createArticle(String description, double price, int stock, LocalDate restockDate, int bateryDuration){
        Electronic electronic = Electronic.builder().description(description).price(price).stock(stock).restockDate(restockDate).bateryDuration(bateryDuration).build();
        articleDao.save(electronic);
        return electronic;
    }

    public Article getArticle(int id){
        return articleDao.get(id);
    }

    public List<Article> getArticles(){
        return articleDao.get();
    }

    public void updateArticle(Article article) {
        articleDao.save(article);
    }

    public void deleteArticle(Article article) {
        articleDao.delete(article);
    }

    public List<Article> getArticlesByType(Class daughterClass){
        return articleDao.getArticlesByType(daughterClass);
    }


    /// CRUD Customer
    public void createCustomer(String name) {
        Customer customer = Customer.builder().name(name).build();
        customerDao.save(customer);
    }

    public Customer getCustomer(int id){
        return customerDao.get(id);
    }

    public List<Customer> getCustomers(){
        return customerDao.get();
    }

    public void updateCutomer(Customer customer) {
        customerDao.save(customer);
    }

    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }

    /// CRUD Seilling
    public void createSelling(Customer customer,List<Article> articles) {
        Selling selling = Selling.builder().customer(customer).sellingStatus(SellingStatus.OUTSTANDING).articles(articles).build();
        sellingDao.save(selling);
    }

    public Selling getSelling(int id){
        return sellingDao.get(id);
    }

    public List<Selling> getSellings(){
        return sellingDao.get();
    }

    public void updateSelling(Selling selling) {
        sellingDao.save(selling);
    }

    public void deleteSelling(Selling selling) {
        sellingDao.delete(selling);
    }

}
