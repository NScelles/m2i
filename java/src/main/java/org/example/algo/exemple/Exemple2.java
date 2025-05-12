package org.example.algo.exemple;

import java.util.Scanner;

public class Exemple2 {
    public static void main(String[] args) {
        String nom, prenom, nomComplet;
        //canner scanner = new Scanner(System.in);

        System.out.println("entrez votre nom");
        nom = new Scanner(System.in).nextLine();

        System.out.println("entrez votre prénom");
        prenom = new Scanner(System.in).nextLine();

        nomComplet = nom + " " + prenom;
        System.out.println("Votre nom complet est " + nomComplet);


    }
}

