package org.example.algo.exercice;

import static org.example.outils.Outils.getReel;

public class Exercice16 {
    public static void main(String[] args) {
        double repUtilsateur=getReel("Donnez un nombre"), max = repUtilsateur, min = repUtilsateur, moy = repUtilsateur;
        final int totalNote = 20;
        for (int i = 1; i < totalNote; i++) {
            if ((repUtilsateur = getReel("Donnez un nombre")) > max) max = repUtilsateur;
            if (repUtilsateur < min) min = repUtilsateur;
            moy+=repUtilsateur;
        }
        System.out.println("La plus petite note tapé est " + min);
        System.out.println("La plus grande note tapé est " + max);
        System.out.printf("La moyenne des notes est %.2f",moy/totalNote);
    }

}
