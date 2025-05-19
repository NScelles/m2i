package org.example.javapoo.tppapetrie.facture;

import org.example.javapoo.tppapetrie.article.Article;

public class Ligne {
    private Article article;
    private int quantite;

    public Ligne(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    public double getPrix(){
        return article.getPrix() * quantite;
    }

    public String afficheLigne() {
        return article.affichageFacture(quantite);
    }
}
