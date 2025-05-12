package org.example.algo.exercice;

import org.example.outils.Outils;

public class Exercice4 {
    public static void main(String[] args) {
        int entier = Outils.getEntier("Donnez un nombre entier");
        if (entier % 3 == 0)
            System.out.println(entier + " est divisible par 3");
        else
            System.out.println(entier + " n'est pas divisible par 3");
    }


}
