package org.example.algo.exercice;

import java.util.Scanner;

import static org.example.outils.Outils.getEntier;
import static org.example.outils.Outils.getReel;

public class Exercice6 {
    public static void main(String[] args) {
        double capital = getReel("Donnez votre capital"),
                taux = getReel("Donnez votre taux en poucentage");
        int nbAnnee = getEntier("Combien d'année voulez vous placer ?");
        System.out.printf("Vous allez gagner %.2f euros", (capital*Math.pow((1+taux/100),nbAnnee) - capital));
    }
}
