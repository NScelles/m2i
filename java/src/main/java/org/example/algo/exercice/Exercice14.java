package org.example.algo.exercice;

import org.example.outils.Outils;

public class Exercice14 {
    public static void main(String[] args) {
        int nbr = Outils.getEntier("Donnez un nombre");
        System.out.println("La somme des entiers jusqu'à " + nbr + " = " + (nbr*(nbr+1))/2);
    }
}
