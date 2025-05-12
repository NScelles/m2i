package org.example.algo.exercice;

import org.example.outils.Outils;

public class Exercice7 {
    public static void main(String[] args) {
        int age = Outils.getEntier("Quel est votre âge ?");
        System.out.print("C'est un ");
        if(age>3 && age <=18) {
            if (age <= 6)
                System.out.println("Baby");
            else if (age <= 8)
                System.out.println("Poussin");
            else if (age <= 10)
                System.out.println("Pupille");
            else if (age <= 12)
                System.out.println("Minime");
            else
                System.out.println("Cadet");
        } else
            System.out.println("Problème");
    }
}
