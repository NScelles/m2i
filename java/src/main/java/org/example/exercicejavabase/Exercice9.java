package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice9 {
    public static void main(String[] args) {
        System.out.println("Le nombre saisi est " + ((getEntier("Saisir un nombre :")%2==0) ? "pair" : " impair"));
    }
}
