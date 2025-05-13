package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice8 {
    public static void main(String[] args) {
        int age = getEntier(" Saisir un age :");
        if(age>=18)
            System.out.println("Vous êtes majeur, vous pouvez rentrer dans le club");
        else
            System.out.println("Vous êtes mineur, y'a rien à voir ici");
    }
}
