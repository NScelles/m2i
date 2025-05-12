package org.example.algo.exercice;

import org.example.outils.Outils;

import static org.example.outils.Outils.getReel;

public class Exercice20 {
    public static void main(String[] args) {
        double[] tab = new double[Outils.getEntier("Combien de notes voulez-vous ?")];
        saisieTableau(tab);
        afficheTableau(tab);
    }

    private static void saisieTableau(double[] tab) {
        for (int i = 0; i < tab.length; i++)
            tab[i] = getReel("Donnez une note");
    }

    private static void afficheTableau(double[] tab) {
        for (int i = 0; i < tab.length; i++)
            System.out.println("Note numéro " + (i + 1) + " : " + tab[i]);
    }
}
