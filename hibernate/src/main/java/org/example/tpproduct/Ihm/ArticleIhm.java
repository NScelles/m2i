package org.example.tpproduct.Ihm;

import org.example.tpproduct.models.articles.Article;
import org.example.tpproduct.models.articles.Articles;
import org.example.tpproduct.models.articles.Electronic;
import org.example.tpproduct.models.articles.Food;
import org.example.tpproduct.models.articles.clothing.Categories;
import org.example.tpproduct.models.articles.clothing.Clothes;

import java.time.LocalDate;
import java.util.*;

import static org.example.utils.Utils.*;

public class ArticleIhm extends Ihm {

    public static void start() {
        boolean running = true;
        while (running) {
            System.out.println("""
                        1 - Ajouter un produit
                        2 - Voir tous les produits
                        3 - Rechercher un produit
                        4 - Modifier un produit
                        5 - Supprimer un produit
                        6 - Aficher un produit selon son type
                        0 - Quitter
                        """);
            int choice = getInt("Choix :");
            switch (choice) {
                case 0 -> running=false;
                case 1 -> createArticle();
                case 2 -> showAllArticle();
                case 3 -> showArticleById();
                case 4 -> updateArticle();
                case 5 -> deleteArticle();
                case 6 -> showArticlesByType();
                default -> System.out.println("Choix invalide");
            }
        }
        System.out.println("Au revoir !");
    }

    private static void showArticlesByType() {
        String type = getString("Quel type de produit voulez-vous afficher ? " + Arrays.stream(Articles.values()).toList());
        switch (type){
            case "Food" -> {
                    for ( Article article:storeService.getArticlesByType(Food.class)){
                        Food food  = (Food) article;
                        System.out.println(food);
                    }
            }
            case "Electronic" -> {
                for (Article article : storeService.getArticlesByType(Electronic.class)) {
                    Electronic electronic = (Electronic) article;
                    System.out.println(electronic);
                }
            }
            case "Clothes" ->{
                for ( Article article:storeService.getArticlesByType(Clothes.class)){
                    Clothes clothes  = (Clothes) article;
                    System.out.println(clothes);
                }
            }
            default -> {
                System.out.println("ça existe pas !");
            }
        }
    }


    private static void deleteArticle() {
        int id = getInt("Quels est l'ID du produit ?");
        storeService.deleteArticle(storeService.getArticle(id));

    }

    private static void updateArticle() {
        int id = getInt("Quels est l'ID du produit ?");
        Article article = storeService.getArticle(id);
        Map<String,Object> dataArticle = getDataArticle();
        switch (Articles.valueOf(article.getClass().getSimpleName())){
            case Articles.Food -> updateFood((Food) article,dataArticle);
            case Articles.Electronic -> updateElectronic((Electronic) article,dataArticle);
            case Articles.Clothes -> updateClothes((Clothes) article,dataArticle);
        }
        storeService.updateArticle(article);
    }

    private static Article updateClothes(Clothes clothes,Map<String,Object> dataArticle) {

        Categories category = Categories.getCatergories(
                getString("Quel la catégoie du vêtement ? " + Arrays.stream(Categories.values()).toList())
        );
        int size = getInt("Quel est sa taille en cm ? ");
        clothes.update(dataArticle.get("description").toString(),(double) dataArticle.get("price"), (int) dataArticle.get("stock"), (LocalDate) dataArticle.get("restockDate"),size,category);
        return clothes;
    }

    private static Article updateElectronic(Electronic electronic,Map<String,Object> dataArticle) {
        int bateryDuration = getInt("Quel est la durée de sa batterie ? ");
        electronic.update(dataArticle.get("description").toString(),(double) dataArticle.get("price"), (int) dataArticle.get("stock"), (LocalDate) dataArticle.get("restockDate"),bateryDuration);
        return electronic;
    }

    private static Article updateFood(Food food,Map<String,Object> dataArticle) {
        LocalDate expiryDate = LocalDate.parse(getString("Quel est la date de re-stock ? (yyyy-MM-dd)"));
        food.update(dataArticle.get("description").toString(),(double) dataArticle.get("price"), (int) dataArticle.get("stock"), (LocalDate) dataArticle.get("restockDate"),expiryDate);
        return food;
    }

    private static void showAllArticle() {
        for(Article article: storeService.getArticles())
            System.out.println("Id :  "+ article.getId() + "|" + article);
    }


    private static void showArticleById() {
        int id = getInt("Quels est l'ID du produit ?");
        System.out.println(storeService.getArticle(id));
    }

    private static void createArticle() {

        String type = getString("Quel type de produit voulez-vous créer ? " + Arrays.stream(Articles.values()).toList());

        switch (type.toUpperCase()){
            case "FOOD" -> addFood(getDataArticle());
            case "ELECTRONIC" -> addElectronic(getDataArticle());
            case "CLOTHES" -> addClothes(getDataArticle());
            default -> System.out.println("ça existe pas !");
        }
    }

    private static Map<String,Object> getDataArticle(){
        Map<String,Object> dataArticle = new HashMap<>();
        dataArticle.put("description",getString("Quel est la decription de l'article ?"));
        dataArticle.put("price",getDouble("Quel est le prix de l'article ?"));
        dataArticle.put("stock",getInt("Quel est le stock de l'article ?"));
        dataArticle.put("restockDate", LocalDate.parse(getString("Quel est la date de re-stock ? (yyyy-MM-dd)")));
        return dataArticle;
    }

    private static void addClothes(Map<String,Object> dataArticle) {
       Categories category = Categories.getCatergories(
               getString("Quel la catégoie du vêtement ? " + Arrays.stream(Categories.values()).toList())
       );
       int size = getInt("Quel est sa taille en cm ? ");

       storeService.createArticle(dataArticle.get("description").toString(),(double) dataArticle.get("price"), (int) dataArticle.get("stock"), (LocalDate) dataArticle.get("restockDate"),size,category);

    }

    private static void addElectronic(Map<String,Object> dataArticle) {
        int bateryDuration = getInt("Quel est la durée de sa batterie ? ");

        storeService.createArticle(dataArticle.get("description").toString(),(double) dataArticle.get("price"), (int) dataArticle.get("stock"), (LocalDate) dataArticle.get("restockDate"),bateryDuration);

    }

    private static void addFood(Map<String,Object> dataArticle){
        LocalDate expiryDate = LocalDate.parse(getString("Quel est la date de péremption ? (yyyy-MM-dd)"));

        storeService.createArticle(dataArticle.get("description").toString(),(double) dataArticle.get("price"), (int) dataArticle.get("stock"), (LocalDate) dataArticle.get("restockDate"),expiryDate);

    }

}
