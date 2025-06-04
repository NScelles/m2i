package org.example.productexercise.Ihm;

import org.example.productexercise.models.Article;
import org.example.productexercise.models.Product;
import org.example.productexercise.services.ProductService;

import java.time.LocalDate;

import static org.example.utils.Utils.*;

public class ProductIhm {

    private static ProductService productService = new ProductService();


    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                        1 - Ajouter un produit
                        2 - Voir tous les produits
                        3 - Rechercher un produit
                        4 - Modifier un produit
                        5 - Supprimer un produit
                        6 - Afficher les produits supérieure à un prix donné
                        7 - Afficher les produits achetés entre 2 dates
                        8 - Afficher les stocks inférieurs à une valeur
                        9 - Afficher les stocks des produits d'une marque
                        10 - Afficher le prix moyen des produits
                        11 - Afficher les produits d'une marque
                        12 - Supprimer les produits d'une marque
                        0 - Quitter
                        """);
            int choice = getInt("Choix :");
            switch (choice) {
                case 0 -> running=false;
                case 1 -> createProduit();
                case 2 -> showAllProduct();
                case 3 -> showProdutById();
                case 4 -> updateProduct();
                case 5 -> deleteProduct();
                case 6 -> getProductsPriceUpTo();
                case 7 -> getProductsBuyBetween();
                case 8 -> getArticlesStockLowerThan();
                case 9 -> getStockByBrand();
                case 10 -> getAvgPrice();
                case 11 -> getProductsByBrand();
                case 12 -> deleteProductByBrand();
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void deleteProductByBrand() {
        String brand = getString("Quel est la marque ?");
        boolean isDelete = productService.deleteByBrand(brand);
        String msg = (isDelete) ? "C'est supprmé" : "Cela n'a pas fonctionné";
        System.out.println(msg);
    }

    private static void getStockByBrand() {
        String brand = getString("Quel est la marque ?");
        System.out.println(productService.getStocksByBrand(brand));
    }

    public static void getArticlesStockLowerThan(){
        int stock = getInt("Le stock est inférieur à :");
        System.out.println(productService.getArtilcesStockLowerThan(stock));
    }

    public static void getProductsByBrand(){
        String brand = getString("Quel est la marque ?");
        System.out.println(productService.getProductsByBrand(brand));
    }

    public static void getAvgPrice(){
        System.out.println( "Le prix moyen des produits est : " + productService.getAvgPrice());
    }

    private static void getProductsBuyBetween() {
        LocalDate dateMin = LocalDate.parse(getString("Quel est la date minimum ? (yyyy-MM-dd)"));
        LocalDate dateMax = LocalDate.parse(getString("Quel est la date maximum ? (yyyy-MM-dd)"));
        System.out.println(productService.getProductsBuyBetween(dateMin,dateMax));
    }

    private static void getProductsPriceUpTo() {
        double priceMin = getDouble("Quel est le prix minimum des produits à afficher");
        System.out.println(productService.getProductsPriceUpTo(priceMin));
    }

    private static void deleteProduct() {
        int id = getInt("Quels est l'ID du produit ?");
        productService.deleteProduct(productService.getProduct(id));

    }

    private static void updateProduct() {
        int id = getInt("Quels est l'ID du produit ?");
        Product product = productService.getProduct(id);
        String brand = getString("Quel est le nom de la marque ?");
        String ref = getString("Quel est sa réference ?");
        LocalDate purchaseDate = LocalDate.now();
        double price = getDouble("Quel est son prix ?");
        int stock = getInt("Combien il a de stock ?");
        product.update(brand,ref,purchaseDate,price,stock);
        productService.updateProduct(product);
    }

    private static void showAllProduct() {
        for(Product product: productService.getProducts())
            System.out.println(product);
    }


    private static void showProdutById() {
        int id = getInt("Quels est l'ID du produit ?");
        System.out.println(productService.getProduct(id));
    }

    private static void createProduit() {
        String brand = getString("Quel est le nom de la marque ?");
        String ref = getString("Quel est sa réference ?");
        LocalDate purchaseDate = LocalDate.now();
        double price = getDouble("Quel est son prix ?");
        int stock = getInt("Combien il a de stock ?");
        productService.createProduct(brand,ref,purchaseDate,price,stock);
    }
}
