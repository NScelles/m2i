package org.example.productexercise.services;

import org.example.productexercise.dao.CommentDao;
import org.example.productexercise.dao.ImageDao;
import org.example.productexercise.dao.ProductDao;
import org.example.productexercise.models.Article;
import org.example.productexercise.models.Comment;
import org.example.productexercise.models.Image;
import org.example.productexercise.models.Product;

import java.time.LocalDate;
import java.util.List;

public class ProductService {
    ProductDao productDao = new ProductDao();
    ImageDao imageDao = new ImageDao();
    CommentDao commentDao = new CommentDao();


    /// CRUD Product
    public void createProduct(String brand, String ref, LocalDate purchaseDate, double price, int stock) {
        Product product = Product.builder().brand(brand).ref(ref).purchaseDate(purchaseDate).price(price).stock(stock).build();
        productDao.save(product);
    }

    public Product getProduct(int id){
        return productDao.get(id);
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

    public List<Product> getProductsPriceUpTo(double priceMin){
        return productDao.getProductsPriceUpTo(priceMin);
    }

    public List<Product> getProductsBuyBetween(LocalDate dateMin, LocalDate dateMax){
        return productDao.getProductsBuyBetween(dateMin,dateMax);
    }

    public List<Article> getArtilcesStockLowerThan(int stock){
        return productDao.getArticlesStockLowerThan(stock);
    }

    public List<Product> getProductsByBrand(String brand){
        return productDao.getProductsByBrand(brand);
    }

    public Double getAvgPrice(){
        return productDao.getAvgPrice();
    }

    public boolean deleteByBrand(String brand){
        return productDao.deleteByBrand(brand);
    }

    public List<Product> getStocksByBrand(String brand){
        return productDao.getStocksByBrand(brand);
    }

    public List<Product> getMostRatingProducts(double avg){
        return productDao.getMostRatingProducts(avg);
    }

    /// CRUD Image
    public void createImage(String url) {
        Image image = Image.builder().url(url).build();
        imageDao.save(image);
    }

    public Image getImage(int id){
        return imageDao.get(id);
    }

    public List<Image> getImages(){
        return imageDao.get();
    }

    public void updateImage(Image image) {
        imageDao.save(image);
    }

    public void deleteImage(Image image) {
        imageDao.delete(image);
    }

    /// CRUD Comment
    public void createComment(String userComment, LocalDate publicationDate, int rating) {
        Comment comment = Comment.builder().comment(userComment).publicationDate(publicationDate).rating(rating).build();
        commentDao.save(comment);
    }

    public Comment getComment(int id){
        return commentDao.get(id);
    }

    public List<Comment> getComments(){
        return commentDao.get();
    }

    public void updateComment(Comment comment) {
        commentDao.save(comment);
    }

    public void deleteComment(Comment comment) {
        commentDao.delete(comment);
    }

}
