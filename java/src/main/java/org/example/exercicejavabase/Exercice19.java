package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice19 {
    public static void main(String[] args) {
        int chap = getEntier("Saisir un nombre de chapitres :"),
                sousChap = getEntier("Saisir un nombre de sous-partie :");
        for (int i=1;i<=chap;i++) {
            System.out.println("Chapitre " + i);
            for (int j=1;j<=sousChap;j++)
                System.out.println("    Sous-partie "+i+"."+j);
        }
    }
}
