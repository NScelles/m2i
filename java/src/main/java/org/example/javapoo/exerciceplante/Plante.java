package org.example.javapoo.exerciceplante;

import java.awt.*;

public class Plante {
    protected String nom;
    protected double hauteur;
    protected Color  couleurFeuilles;


    public Plante(String nom, double hauteur, Color couleurFeuilles) {
        this.nom = nom;
        this.hauteur = hauteur;
        this.couleurFeuilles = couleurFeuilles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getHauteur() {
        return hauteur;
    }

    public void setHauteur(double hauteur) {
        this.hauteur = hauteur;
    }

    public Color getCouleurFeuilles() {
        return couleurFeuilles;
    }

    public void setCouleurFeuilles(Color couleurFeuilles) {
        this.couleurFeuilles = couleurFeuilles;
    }

    @Override
    public String toString() {
        return "Plante :" +
                "\nnom = " + nom +
                "\nhauteur = " + hauteur +
                "\ncouleurFeuilles = " + couleurFeuilles;
    }
}
