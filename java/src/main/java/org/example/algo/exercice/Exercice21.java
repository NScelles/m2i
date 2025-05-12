package org.example.algo.exercice;

import static org.example.outils.Outils.getReel;

public class Exercice21 {
    public static void main(String[] args) {
        final int N=15,M=3;
        double[][] tab=new double[N][M];
        saisieNote(tab);
        afficheNote(tab);
    }

    private static void afficheNote(double[][] tab) {
        for (int i = 0; i< tab.length; i++)
            for(int j = 0; j< tab[i].length; j++)
                System.out.println("la note de l'étudiant numéro "+ (i+1) + " pour la matière numéro " + j + " est " + tab[i][j]);
    }

    private static void saisieNote(double[][] tab) {
        for (int i = 0; i< tab.length; i++)
            for(int j = 0; j< tab[i].length; j++)
                tab[i][j]=getReel("Donnez la note de l'étudiant numéro "+ (i+1) + " pour la matière numéro " + j );
    }
}
