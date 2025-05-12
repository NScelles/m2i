package org.example.algo.exercice;

import org.example.outils.Outils;

public class Exercice10 {
    public static void main(String[] args) {
        int repUtilisateur=0;
        while(repUtilisateur<1 || repUtilisateur>3){
            repUtilisateur = Outils.getEntier("Donner un nombre entre 1 et 3");
        }
        System.out.println("Bravo");
    }
}
