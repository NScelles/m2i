package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class exercice4 {
    public static void main(String[] args) {
        int age = getEntier(" Saisir un age :");
        System.out.println(age>=18);
    }
}
