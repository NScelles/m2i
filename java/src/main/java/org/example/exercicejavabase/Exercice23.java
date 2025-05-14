package org.example.exercicejavabase;

import org.example.outils.Outils;

import static org.example.outils.Outils.getEntier;
import static org.example.outils.Outils.getReel;

public class Exercice23 {
    public static void main(String[] args){
        final int totalNote = getEntier("Combien de notes souhaitez-vous saisir :");
        if(totalNote>0) {
            double repUtilsateur = getReel("note 1 :"),
                    max = repUtilsateur,
                    min = repUtilsateur,
                    moy = repUtilsateur;
            for (int i = 2; i <= totalNote; i++) {
                if ((repUtilsateur = getReel("note "+ i +": ")) > max)
                    max = repUtilsateur;
                if (repUtilsateur < min) min = repUtilsateur;
                moy += repUtilsateur;
            }
            System.out.println("La plus grande note tapé est " + max);
            System.out.println("La plus petite note tapé est " + min);
            System.out.printf("La moyenne des notes est %.2f", moy / totalNote);
        }
    }
}
