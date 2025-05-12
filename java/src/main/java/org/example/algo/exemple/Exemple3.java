package org.example.algo.exemple;

import java.util.Scanner;

public class Exemple3 {

    public static void main(String[] args) {
        System.out.println("Entrez un réel");
        System.out.println("votre nombre " + getReel());

    }

    private static double getReel() {
        double reel = 0;
        boolean nombreValide = false;
        do {
            try {
                System.out.println("Donnez un nombre entier");
                reel = new Scanner(System.in).nextDouble();
                nombreValide=true;
            } catch (Exception e){
                System.out.println("La valeur rentrée n'est pas valide");

            };
        }while (!nombreValide);
        return reel;
    }
}
