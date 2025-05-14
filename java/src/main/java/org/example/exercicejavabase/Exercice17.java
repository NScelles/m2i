package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice17 {
    public static void main(String[] args) {
        String reponse = "";
        if (getEntier("Saisir un âge : ")<30)
            reponse += "Vous êtes trop jeune\n";
        if (getEntier("Saisir le salaire souhaité : ")>40000)
            reponse +="Tu coûtes trop chère\n";
        if (getEntier("Saisir le nombre d'années d'expériences : ")<4)
            reponse +="Vous manquez d'expérience\n";
        System.out.println(reponse);
    }
}
