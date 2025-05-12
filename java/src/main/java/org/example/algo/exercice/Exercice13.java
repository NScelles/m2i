package org.example.algo.exercice;

import static org.example.outils.Outils.getReel;

public class Exercice13 {
    public static void main(String[] args) {
        double repUtilsateur, max = 0;
        for (int i = 0; i <= 6; i++) if ((repUtilsateur = getReel("Donnez un nombre")) > max) max=repUtilsateur;
        System.out.println("le plus grand nombre tapé est " + max);
    }

}
