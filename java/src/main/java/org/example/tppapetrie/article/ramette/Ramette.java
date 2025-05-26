package org.example.tppapetrie.article.ramette;

import org.example.tppapetrie.article.ArticleUnitaire;

public class Ramette extends ArticleUnitaire {

    private int grammage;

    public Ramette(String nom, double prixUnitaire, int grammage) {
        super(nom, prixUnitaire);
        this.grammage = grammage;
    }

    @Override
    public String toString() {
        return "Ramette{" +
                "grammage=" + grammage +
                ", nom='" + nom + '\'' +
                ", prixUnitaire=" + prixUnitaire +
                ", ref=" + ref +
                '}';
    }

    @Override
    public double getPrix() {
        return prixUnitaire;
    }

    @Override
    public String affichageFacture(int quantite){
        return quantite + " | " +
                this.ref + " | " +
                this.nom + " | " +
                this.prixUnitaire  + " | " +
                this.prixUnitaire * quantite;
    }
}
