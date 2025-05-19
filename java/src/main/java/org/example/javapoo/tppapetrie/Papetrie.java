package org.example.javapoo.tppapetrie;

import org.example.javapoo.tppapetrie.article.Article;
import org.example.javapoo.tppapetrie.facture.Facture;

import java.util.HashMap;
import java.util.Map;

public class Papetrie {
    private static Map<Integer, Article> lesArticles = new HashMap<>();
    private static Map<Integer, Facture> lesFactures = new HashMap<>();

    public Papetrie() {
        this(new HashMap<>());
    }

    public Papetrie(Map<Integer, Article> lesArticles) {
        Papetrie.lesArticles.putAll(lesArticles);
    }

    public static Article getArticleById(int ref){
        return lesArticles.get(ref);
    }

    public static Facture getFactureById(int ref){
        return lesFactures.get(ref);
    }

    public static boolean isExist(Integer ref){
        return lesArticles.containsKey(ref);
    }

    public void ajouterArticleFacture(int refFacture, int refArticle, int quantite){
        lesFactures.get(refFacture).ajouterLigne(refArticle,quantite);
    }

    public void nouvelleFacture(String nomClient){
        lesFactures.put(Facture.getComtp(),new Facture(nomClient));
    }

    public void ajouterFacture(String nomClient,int nbLigneMax){
        lesFactures.put(Facture.getComtp(),new Facture(nomClient,nbLigneMax));
    }

    public static Facture getLastFactureByNom(String nom){
        int last=-1;
        for (Facture facture:lesFactures.values()){
            if (facture.getClient().equals(nom) && last<=facture.getNumeroFacture())
                last=facture.getNumeroFacture();

        }
        return lesFactures.get(last);
    }

    public void ajouterArticle(Article article){
        lesArticles.put(article.getRef(),article);
    }

    public static Map<Integer, Article> getLesArticles() {
        return lesArticles;
    }

    @Override
    public String toString() {
        return "Papetrie{" +
                "lesArticles=" + lesArticles +
                '}';
    }
}
