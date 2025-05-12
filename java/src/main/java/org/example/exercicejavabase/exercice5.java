package org.example.exercicejavabase;

import static org.example.outils.Outils.getReel;

public class exercice5 {
    public static void main(String[] args) {
        double r = getReel("Saisir un rayon :"),
                h = getReel("Saisir une hauteur :");
        double result = (((double) 1 /3) * Math.PI * r*r * h);
        System.out.printf(" Le volume du cône est de %.2f cm3", result);
    }
}
