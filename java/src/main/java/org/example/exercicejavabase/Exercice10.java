package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice10 {
    public static void main(String[] args) {
        int nombre1 = getEntier("Saisir nombre1 :"),
                nombre2 = getEntier("Saisir nombre2 :"),
                nombre3 = getEntier("Saisir nombre3 :"),
                max;
        if(nombre1>nombre2 && nombre1>nombre3)
            max = nombre1;
        else max = Math.max(nombre2, nombre3);
        System.out.println("La valeur maximal est " + max);
    }
}
