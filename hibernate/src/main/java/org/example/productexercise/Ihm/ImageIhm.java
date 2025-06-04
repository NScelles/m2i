package org.example.productexercise.Ihm;

import org.example.productexercise.models.Image;
import org.example.productexercise.models.Product;

import java.time.LocalDate;

import static org.example.utils.Utils.*;

public class ImageIhm extends Ihm{
    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                        1 - Ajouter une image
                        2 - Voir toutes les images
                        3 - Rechercher une image
                        4 - Modifier une image
                        5 - Supprimer une image
                        6 - Associer un produit
                        0 - Quitter
                        """);
            int choice = getInt("Choix :");
            switch (choice) {
                case 0 -> running=false;
                case 1 -> createImage();
                case 2 -> showAllImage();
                case 3 -> showImageById();
                case 4 -> updateImage();
                case 5 -> deleteImage();
                case 6 -> associateImageProduct();
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void associateImageProduct() {
        int idImage = getInt("Quels est l'ID de l'image ?");
        Image image = productService.getImage(idImage);
        int idProduct = getInt("Quels est l'ID du produit ?");
        Product product = productService.getProduct(idProduct);
        image.setProduct(product);
        productService.updateImage(image);
    }

    private static void deleteImage() {
        int id = getInt("Quels est l'ID de l'image ?");
        productService.deleteImage(productService.getImage(id));
    }

    private static void updateImage() {
        int id = getInt("Quels est l'ID de l'image ?");
        Image image = productService.getImage(id);
        String url = getString("Quel est l'URL de l'image ?");
        image.setUrl(url);
        productService.updateImage(image);
    }

    private static void showImageById() {
        int id = getInt("Quels est l'ID de l'image  ?");
        System.out.println(productService.getImage(id));
    }

    private static void showAllImage() {
        for(Image image: productService.getImages())
            System.out.println(image);
    }

    private static void createImage() {
        String url = getString("Quel est l'URL de l'image ?");
        productService.createImage(url);
    }
}
