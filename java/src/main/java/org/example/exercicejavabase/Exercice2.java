package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice2 {
    public static void main(String[] args) {
        int a = getEntier("Saisir a :"),
                b = getEntier("Saisir b :"),
                c;

        System.out.println("a = " + a + " et b = " + b);

        // Inversion
        c = a;
        a = b;
        b = c;

        System.out.print("a = " + a + " et b = " + b);

    }
}
