package org.example.exercicejavabase;

import java.util.Arrays;

import static org.example.outils.Outils.getRandomEntier;

public class Exercice29 {
    /// Fait après la fin du temps réglementaire
    public static void main(String[] args) {
        final int N = 10;
        int compt = 0;
        int[] tabSource= new int[N],
                tabDestination = new int[N];
        for(int i = 0; i<N;i++)
            tabSource[i]= getRandomEntier(-100,99);
        for(int i = 0; i<N;i++) {
            if(tabSource[i]>0) {
                tabDestination[compt] = tabSource[i];
                compt++;
            }
        }
        System.out.println(Arrays.toString(tabSource));
        System.out.println(Arrays.toString(tabDestination));
    }
}
