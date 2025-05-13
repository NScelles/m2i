package org.example.exercicejavabase;

import static org.example.outils.Outils.getRandomEntier;

public class Exercice29 {
    public static void main(String[] args) {
        final int N = 10;
        int[] tabSource= new int[N],
                tabDestination = new int[N];
        for(int i = 0; i<N;i++)
            tabSource[i]= getRandomEntier(-100,100);
        for(int i = 0; i<N;i++) {
            if(tabSource[i]>0)
                tabDestination[i]=tabSource[i];
        }
        System.out.println(tabSource);
        System.out.println(tabDestination);
    }
}
