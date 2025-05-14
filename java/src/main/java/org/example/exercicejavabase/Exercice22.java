package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice22 {
    public static void main(String[] args) {
        int nbr = getEntier("Saisir un nombre :"),
                compt;
        String reponse;
        for (int i=1;i<=Math.round(nbr/2);i++){
            compt = 0;
            reponse ="";
            for(int j=i;j<=Math.round(nbr/2)+1;j++){
                compt+=j;
                if(compt==nbr)
                    System.out.println(nbr + " = " + reponse + j);
                else
                    reponse+= j + " + ";
            }
        }
    }
}
