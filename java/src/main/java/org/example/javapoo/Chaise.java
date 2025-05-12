package org.example.javapoo;


import org.example.outils.Outils;

import java.awt.*;

import static org.example.outils.Outils.getRandomDouble;

public class Chaise {

    private int nbrPied;
    private String materiaux ;
    private Color couleur;
    private double prix;

    public Chaise() {
        this.nbrPied = Outils.getRandomEntier(1,5);
        this.materiaux = "plastique";
        this.couleur = new Color(0x000000);
        this.prix = getRandomDouble(1,100);
    }

    public Chaise(int nbrPied, String materiaux, Color color, double prix) {
        this.nbrPied = nbrPied;
        this.materiaux = materiaux;
        this.couleur = color;
        this.prix = prix;
    }

    public void CasserPied(int nbrPied){
        if(this.nbrPied - nbrPied>=0) this.nbrPied-=nbrPied;
    }

    public int getNbrPied() {
        return nbrPied;
    }

    public void setNbrPied(int nbrPied) {
        this.nbrPied = nbrPied;
    }

    public String getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(String materiaux) {
        this.materiaux = materiaux;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Je suis une chaise avec "+nbrPied+
                " pied(s) en "+materiaux+
                " de couleur "+ couleur +
                " à un prix de " + Math.floor(prix*100)/100+
                "\n";
    }
}
