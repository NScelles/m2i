package org.example.heritageexercise.ihm;

import org.example.heritageexercise.models.Electronic;
import org.example.heritageexercise.models.ProductType;
import org.example.tpcomputer.models.Project;

import static org.example.utils.Utils.*;

public class ElectronicIhm extends Ihm {

    public static void deleteProduit() {
        int id = getInt("Quels est l'ID du produit ?");
        marketService.deleteElectronic(id);
    }

    public static void updateProduit() {
        int id = getInt("Quels est l'ID du Produit ?");
        String name = getString("Quels est le nom du Produit ?");
        double price = getDouble("Quels est le prix du Produit ?");
        double batteryDuration = getDouble("Quels est la durée batterie du Produit ?");
        marketService.updateElectronic(Electronic.builder().id(id).name(name).price(price).batteryDuration(batteryDuration).build());
    }

    public static void showAllProduit() {
        System.out.println(marketService.getElectronics());
    }


    public static void showProduitById() {
        int id = getInt("Quels est l'ID du Produit ?");
        System.out.println(marketService.getElectronic(id));
    }

    public static void createProduit() {
        String name = getString("Quels est le nom du Projet ?");
        double price = getDouble("Quels est le prix du Produit ?");
        double batteryDuration = getDouble("Quels est la durée batterie du Produit ?");
        marketService.createElectronic(name, price, batteryDuration);
    }
}
