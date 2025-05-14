package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice14 {
    public static void main(String[] args) {
        int annee = getEntier("Saisir une année : ");
        if (annee%4==0 && annee%100!=0 || annee%400==0)
            System.out.println(annee+ "est une année bissextile");
        else
            System.out.println(annee+ "n'est une année bissextile");
    }
}
