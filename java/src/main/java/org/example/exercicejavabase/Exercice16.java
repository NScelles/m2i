package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice16 {
    public static void main(String[] args) {
        int temp = getEntier(" Saisir une température : ");
        if (temp>100)
            System.out.println("GAZEUX");
        else if(temp<0)
            System.out.println("SOLIDE");
        else
            System.out.println("LIQUIDE");
    }
}
