package org.example.javapoo.tppapetrie.article;

public abstract class ArticleUnitaire extends Article{

    protected String nom;
    protected double prixUnitaire;

    public ArticleUnitaire(String nom, double prixUnitaire) {
        super();
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
    }

    public String affichageFacture(int quantite){
        return quantite + " | " +
                this.ref + " | " +
                this.nom + " | " +
                this.prixUnitaire  + " | " +
                this.prixUnitaire * quantite;
    }

    public String getNom() {
        return nom;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }
}
