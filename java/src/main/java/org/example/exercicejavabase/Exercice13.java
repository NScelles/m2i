package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice13 {
    public static void main(String[] args) {
        switch (getEntier(" Saisir un numéro de mois : ")) {
            case 1,3,5,7,8,10,12 -> System.out.println("31");
            case 4,6,9,11 -> System.out.println("30");
            case 2 -> System.out.println("28 (29 en année bisextile)");
            default -> System.out.println("C'est pas un numéro de mois");
        }
    }
}
