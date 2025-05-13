package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice22 {
    public static void main(String[] args) {
        int nbr = getEntier("Saisir un nombre :"),
                compt;
        String reponse;
        for (int i=1;i<=nbr;i++){
            compt = 0;
            reponse ="";
            for(int j=i;j<nbr;j++){
                compt+=j;
                if(compt==nbr)
                    System.out.println(nbr + " = " + reponse + j);
                else
                    reponse+= j + " + ";
            }
        }
    }
}
