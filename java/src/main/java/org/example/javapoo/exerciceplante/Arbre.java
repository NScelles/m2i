package org.example.javapoo.exerciceplante;

import java.awt.*;

public class Arbre extends Plante{

    private double circonference;


    public Arbre(String nom, double hauteur, Color couleurFeuilles,double circonference) {
        super(nom, hauteur, couleurFeuilles);
        this.circonference = circonference;
    }

    @Override
    public String toString() {
        String affichage = super.toString() + "\ncirconférence = " + this.circonference;
        return affichage;
    }
}
