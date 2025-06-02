package org.example.heritageexercise.ihm;

import org.example.heritageexercise.models.ProductType;
import org.example.tpcomputer.models.Project;
import org.example.tpcomputer.services.EquipementService;

import static org.example.utils.Utils.getInt;
import static org.example.utils.Utils.getString;

public class MarketIhm extends Ihm {


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
                case 2 -> showAllProduit();
                case 3 -> showProduitById();
                case 4 -> updateProduit();
                case 5 -> deleteProduit();
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void deleteProduit() {
        ProductType productType = ProductType.getProductType(getString("Quel est le type du produit (FOOD, ELECTRONIC, HOUSING)"));
        switch (productType) {
            case FOOD -> FoodIhm.deleteProduit();
            case HOUSING -> ElectronicIhm.deleteProduit();
            case ELECTRONIC -> HousingIhm.deleteProduit();
            default -> System.out.println("Produit n'existe pas !");
        }
    }

    private static void updateProduit() {
        ProductType productType = ProductType.getProductType(getString("Quel est le type du produit (FOOD, ELECTRONIC, HOUSING)"));
        switch (productType) {
            case FOOD -> FoodIhm.updateProduit();
            case HOUSING -> ElectronicIhm.updateProduit();
            case ELECTRONIC -> HousingIhm.updateProduit();
            default -> System.out.println("Produit n'existe pas !");
        }

    }

    private static void showAllProduit() {
            FoodIhm.showAllProduit();
            HousingIhm.showAllProduit();
            ElectronicIhm.showAllProduit();
    }


    private static void showProduitById() {
        ProductType productType = ProductType.getProductType(getString("Quel est le type du produit (FOOD, ELECTRONIC, HOUSING)"));
        switch (productType) {
            case FOOD -> FoodIhm.showProduitById();
            case HOUSING -> HousingIhm.showProduitById();
            case ELECTRONIC -> ElectronicIhm.showProduitById();
            default -> System.out.println("Produit n'existe pas !");
        }
    }

    private static void createProduit() {
        ProductType productType = ProductType.getProductType(getString("Quel est le type du produit (FOOD, ELECTRONIC, HOUSING)"));
        switch (productType) {
            case FOOD -> FoodIhm.createProduit();
            case HOUSING -> HousingIhm.createProduit();
            case ELECTRONIC -> ElectronicIhm.createProduit();
            default -> System.out.println("Produit n'existe pas !");
        }
    }
}
