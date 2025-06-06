package org.example.tpproduct.Ihm;

import org.example.tpproduct.models.articles.Article;
import org.example.tpproduct.models.selling.Selling;
import org.example.tpproduct.models.selling.SellingStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.utils.Utils.getInt;
import static org.example.utils.Utils.getString;

public class SellingIhm extends Ihm {
    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                        1 - Ajouter une vente
                        2 - Voir toutes les ventes
                        3 - Rechercher une vente
                        4 - Modifier une vente
                        5 - Supprimer une vente
                        6 - Ajouter un article à une vente
                        0 - Quitter
                        """);
            int choice = getInt("Choix :");
            switch (choice) {
                case 0 -> running=false;
                case 1 -> createSelling();
                case 2 -> showAllSelling();
                case 3 -> showSellingById();
                case 4 -> updateSelling();
                case 5 -> deleteSelling();
                case 6 -> addArticleToSelling();
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void addArticleToSelling() {
        int idImage = getInt("Quels est l'ID de la vente ?");
        Selling selling = storeService.getSelling(idImage);
        int idProduct = getInt("Quels est l'ID du produit ?");
        Article article = storeService.getArticle(idProduct);
        selling.addArticle(article);
        storeService.updateSelling(selling);
    }

    private static void deleteSelling() {
        int id = getInt("Quels est l'ID de la vente ?");
        storeService.deleteSelling(storeService.getSelling(id));
    }

    private static void updateSelling() {
        int id = getInt("Quels est l'ID de la vente ?");
        Selling selling = storeService.getSelling(id);
        String stingSellingStatus = getString("Quel est le status de la vente ? " + Arrays.stream(SellingStatus.values()).toList());
        SellingStatus sellingStatus = SellingStatus.getSellingStatus(stingSellingStatus);
        selling.setSellingStatus(sellingStatus);
        storeService.updateSelling(selling);
    }

    private static void showSellingById() {
        int id = getInt("Quels est l'ID de la vente  ?");
        System.out.println(storeService.getSelling(id) );
    }

    private static void showAllSelling() {
        for(Selling selling: storeService.getSellings())
            System.out.println(selling.getId()  + "|" + selling.getSellingStatus() + "|"+ selling.getCustomer() + "|" + selling.getArticles());
    }

    private static void createSelling() {
        int idCustomer = getInt("Quel est l'ID du client ?");
        int idArticle = getInt("Quel est l'ID de l'article ?");
        storeService.createSelling(storeService.getCustomer(idCustomer), List.of(storeService.getArticle(idArticle)));
    }
}
