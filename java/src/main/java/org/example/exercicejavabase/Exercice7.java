package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice7 {
    public static void main(String[] args) {
        int age = getEntier(" Saisir la longueur d'un côté : ");
        System.out.println("Le périmètre du carré est de :" + age*4 + "cm");
        System.out.println(" L'aire du carré est de :"+ age*age +"cm carré");
    }
}
