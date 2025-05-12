package org.example.algo.cours;

import java.util.Scanner;

public class Interaction {
    public static void main(String[] args) {
        /// Affichage dans la console
        //Les différent print

        // println : saut de ligne
        System.out.println("Bonjour");
        System.out.println("à");
        System.out.println("tous");
        System.out.println("\n###############\n");

        // print : pas de saut de ligne
        System.out.print("Bonjour");
        System.out.print("à");
        System.out.print("tous");
        System.out.print("\n###############\n");

        int age = 25;
        double poids = 70;
        String nom = "John Doe";

        // printf :
        System.out.printf("Nom: %s, Age: %d, Poids : %.2f",nom,age,poids);

        System.out.println("\n###############\n");

        /// Caratère spécifique

        // \n saut de ligne
        System.out.println("Bonjour \n à tous");
        System.out.println("\n###############\n");

        // \t tabulation
        System.out.println("Bonjour \t à tous");
        System.out.println("\n###############\n");


        /// L'Objet Scanner
        // Scanner nextLine
        Scanner scanner = new Scanner(System.in);
        System.out.println("Quel est votre prénom ?");
        String prenom = scanner.nextLine();
        System.out.println("Bonjour " + prenom);
        System.out.println("\n###############\n");

        // Scanner nextInt
        System.out.println("Quel est votre âge ?");
        int ageUser = scanner.nextInt();
        System.out.println("Vous êtes vieux de " + ageUser + " ans");

        // Fermer le scanner à la fin
        scanner.close();

    }
}
