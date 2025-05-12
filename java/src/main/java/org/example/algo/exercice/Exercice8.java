package org.example.algo.exercice;

import static org.example.outils.Outils.getReel;

public class Exercice8 {
    public static void main(String[] args) {
        double coteAB = getReel("Longueur du coté AB"),
                coteBC = getReel("Longueur du coté BC"),
                coteAC = getReel("Longueur du coté AC");

        if (coteAB == coteAC) {
            if (coteAB == coteBC)
                System.out.println("Equilatéral");
            else
                System.out.println("Isocèle en A");
        } else if (coteAC==coteBC)
            System.out.println("Isocèle en C");
        else if(coteAB == coteBC)
            System.out.println("Isocèle en B");
        else
            System.out.println("Quelconque");
    }
}
