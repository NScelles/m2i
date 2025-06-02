package org.example.heritageexercise.ihm;

import org.example.heritageexercise.models.Electronic;
import org.example.heritageexercise.models.Food;

import java.sql.Date;

import static org.example.utils.Utils.*;
import static org.example.utils.Utils.getDouble;

public class FoodIhm extends Ihm {
    public static void deleteProduit() {
        int id = getInt("Quels est l'ID du produit ?");
        marketService.deleteFood(id);
    }

    public static void updateProduit() {
        int id = getInt("Quels est l'ID du Produit ?");
        String name = getString("Quels est le nom du Produit ?");
        double price = getDouble("Quels est le prix du Produit ?");
        String experyDate = getString("Quels est le date d'expiration du Produit ?");
        marketService.updateFood(Food.builder().id(id).name(name).price(price).expiryDate(experyDate).build());
    }

    public static void showAllProduit() {
        System.out.println(marketService.getFoods());
    }

    public static void showProduitById() {
        int id = getInt("Quels est l'ID du Produit ?");
        System.out.println(marketService.getFood(id));
    }

    public static void createProduit() {
        String name = getString("Quels est le nom du Projet ?");
        double price = getDouble("Quels est le prix du Produit ?");
        String experyDate = getString("Quels est le date d'expiration du Produit ?");
        marketService.createFood(name, price, experyDate);
    }
}
