package org.example.productexercise.Ihm;

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
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
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
