package org.example.javapoo.tppapetrie.facture;

import org.example.javapoo.tppapetrie.article.Article;
import org.example.javapoo.tppapetrie.article.ArticleUnitaire;
import org.example.javapoo.tppapetrie.article.Articles;
import org.example.javapoo.tppapetrie.article.lot.Lot;

public class Ligne {
    private Article article;
    private int quantite;

    public Ligne(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    public double getPrix(){
        double prixTotal;
        switch (article.getTypeOfArticle()){
            case ARTICLEUNITAIRE -> prixTotal = ((ArticleUnitaire) article).getPrixUnitaire() * quantite;
            case LOT -> prixTotal = ((Lot) article).getPrix() * quantite;
            default -> prixTotal = 0;
        }
        return prixTotal;
    }

    public String afficheLigne() {
        String affichage;
        switch (article.getTypeOfArticle()){
            case ARTICLEUNITAIRE -> affichage = ((ArticleUnitaire) article).affichageFacture(quantite);
            case LOT -> affichage = ((Lot) article).affichageFacture();
            default -> affichage = "Article inexistant";
        }
        return affichage;
    }
}
