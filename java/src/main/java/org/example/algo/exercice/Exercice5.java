package org.example.algo.exercice;

import org.example.outils.Outils;

public class Exercice5 {
    public static void main(String[] args) {
        int nbrPhotocopie = Outils.getEntier("Quel est le nombre de photocopie");
        if (nbrPhotocopie < 10)
            System.out.printf("Vous devez payer %.2f euros \n",nbrPhotocopie * 0.5f);
        else if (nbrPhotocopie <= 20)
            System.out.printf("Vous devez payer %.2f euros \n",nbrPhotocopie * 0.4f);
        else
            System.out.printf("Vous devez payer %.2f euros \n",nbrPhotocopie * 0.3f);
    }
}
