package org.example.exercicejavabase;

import java.util.Arrays;

import static org.example.outils.Outils.getRandomEntier;

public class Exercice30 {
    /// Fait après la fin du temps réglementaire
    public static void main(String[] args) {
        final int N = 10;
        int iMax = 0,
        max = -100;
        int[] tabSource= new int[N];
        for(int i = 0; i<N;i++) {
            tabSource[i] = getRandomEntier(-100, 5);
            if (tabSource[i]>max) {
                max = tabSource[i];
                iMax = i;
            }
        }
        System.out.println(Arrays.toString(tabSource));
        System.out.println("La valeur maximale est "+ max +" à l'indice " + iMax);
    }
}
