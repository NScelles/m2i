package org.example.heritageexercise.ihm;

import org.example.heritageexercise.models.Housing;

import static org.example.utils.Utils.*;
import static org.example.utils.Utils.getDouble;

public class HousingIhm extends Ihm {
    public static void deleteProduit() {
        int id = getInt("Quels est l'ID du produit ?");
        marketService.deleteHousing(id);
    }

    public static void updateProduit() {
        int id = getInt("Quels est l'ID du Produit ?");
        String name = getString("Quels est le nom du Produit ?");
        double price = getDouble("Quels est le prix du Produit ?");
        double height = getDouble("Quels est la hauteur du Produit ?");
        double width = getDouble("Quels est la longueur du Produit ?");
        marketService.updateHousing(Housing.builder().id(id).name(name).price(price).height(height).width(width).build());
    }

    public static void showAllProduit() {
        System.out.println(marketService.getHousings());
    }

    public static void showProduitById() {
        int id = getInt("Quels est l'ID du Projet ?");
        System.out.println(marketService.getHousing(id));
    }

    public static void createProduit() {
        String name = getString("Quels est le nom du Projet ?");
        double price = getDouble("Quels est le prix du Produit ?");
        double height = getDouble("Quels est la hauteur du Produit ?");
        double width = getDouble("Quels est la longueur du Produit ?");
        marketService.createHousing(name, price,height,width);
    }
}
