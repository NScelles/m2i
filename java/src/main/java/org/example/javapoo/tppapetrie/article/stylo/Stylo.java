package org.example.javapoo.tppapetrie.article.stylo;

import org.example.javapoo.tppapetrie.article.Article;
import org.example.javapoo.tppapetrie.article.ArticleUnitaire;

public class Stylo extends ArticleUnitaire {

    private CouleurStylo couleur;

    public Stylo(String nom, double prixUnitaire, CouleurStylo couleur) {
        super(Article.compt, nom, prixUnitaire);
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Stylo{" +
                "couleur=" + couleur +
                ", prixUnitaire=" + prixUnitaire +
                ", nom='" + nom + '\'' +
                ", ref=" + ref +
                '}';
    }
}
