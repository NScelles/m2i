package org.example.algo.exercice;

import org.example.outils.Outils;

public class Exercice18 {
    public static void main(String[] args) {
        System.out.println("Le nombre le plus grand est " + plusGrand(Outils.getEntier("Nombre 1"), Outils.getEntier("Nombre 2")));
    }
    private static int plusGrand(int nb1, int nb2){
        return Math.max(nb1, nb2);
    }
}
