package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class exercice3 {
    public static void main(String[] args) {
        int a = getEntier("Saisir a :"),
                b = getEntier("Saisir b :");
        System.out.println(" La somme des carrés de a et b est : " + (a*a+b*b));
    }
}
