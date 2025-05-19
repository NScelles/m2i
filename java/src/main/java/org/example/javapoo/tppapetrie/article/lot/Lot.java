package org.example.javapoo.tppapetrie.article.lot;

import org.example.javapoo.tppapetrie.article.Article;
import org.example.javapoo.tppapetrie.article.ArticleUnitaire;

public class Lot extends Article {
    private ArticleUnitaire article;
    private int quantite;
    private double pourcentageRemise;

    public Lot(ArticleUnitaire article, int quantite, double pourcentageRemise) {
        super();
        this.article = article;
        this.quantite = quantite;
        this.pourcentageRemise = pourcentageRemise;
    }

    public String affichageFacture(int quantiteLot){
        return quantiteLot + " | " +
                article.getRef() + " | " +
                "Lot de " + article.getNom() + " | " +
                getPrix()  + " | " +
                getPrix() * quantiteLot;
    }

    public double getPrix(){
        return quantite * article.getPrixUnitaire() * (pourcentageRemise/100);
    }

    public ArticleUnitaire getArticle() {
        return article;
    }

    @Override
    public String toString() {
        return "Lot{" +
                "article=" + article +
                ", quantite=" + quantite +
                ", pourcentageRemise=" + pourcentageRemise +
                ", ref=" + ref +
                '}';
    }
}
