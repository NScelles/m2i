package org.example.tppapetrie.article.stylo;

import org.example.tppapetrie.article.ArticleUnitaire;

public class Stylo extends ArticleUnitaire {

    private CouleurStylo couleur;

    public Stylo(String nom, double prixUnitaire, CouleurStylo couleur) {
        super(nom, prixUnitaire);
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
