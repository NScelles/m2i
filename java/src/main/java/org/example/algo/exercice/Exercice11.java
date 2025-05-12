package org.example.algo.exercice;

import static org.example.outils.Outils.getReel;

public class Exercice11 {
    public static void main(String[] args) {
        int nbAnnee = 0;
        double taux = getReel("Donnez le taux en pourcentage"),
                capital = getReel("Donnez le capital que vous voulez doubler"),
                capitalInitial = capital;
        while (capital<(capitalInitial*2)){
            nbAnnee++;
            capital += capital*(1+taux/100)-capital;
        }
        System.out.println("nombre d'années nécessaires : "+ nbAnnee);

    }
}
