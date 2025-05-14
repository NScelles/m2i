package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice20 {
    public static void main(String[] args) {
        int nbr = getEntier("Saisir un nombre :");
        for(int i = 0;i<=10;i++)
            System.out.println(i + " x " + nbr + " = " + i*nbr);
    }
}
