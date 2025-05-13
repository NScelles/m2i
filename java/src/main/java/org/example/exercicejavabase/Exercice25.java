package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;
import static org.example.outils.Outils.getRandomEntier;

public class Exercice25 {
    public static void main(String[] args) {
        int nbr = getRandomEntier(1,100),
        nbrJoueur,
        compt = 0;
        //System.out.println(nbr); Pour la vérification
        do{
            compt++;
            nbrJoueur = getEntier("Saisir un nombre :");
            if(nbr > nbrJoueur)
                System.out.println("Le nombre est plus grand");
            else if(nbr < nbrJoueur)
                System.out.println("Le nombre est plus petit");
        }while (!(nbr == nbrJoueur));
        System.out.println("Vous avez gagné en "+ compt + " tentative(s)");
    }
}
