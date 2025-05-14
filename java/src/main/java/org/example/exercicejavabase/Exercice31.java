package org.example.exercicejavabase;

import java.util.Arrays;

import static org.example.outils.Outils.getRandomEntier;


/// Fait après la fin du temps réglementaire
public class Exercice31 {
    public static void main(String[] args) {
        boolean isEquals = true;

        int[] tabUn= new int[getRandomEntier(1,3)],
                tabDeux= new int[getRandomEntier(1,3)];
        for(int i = 0; i<tabUn.length;i++)
            tabUn[i] = getRandomEntier(0, 3);
        for(int i = 0; i<tabDeux.length;i++)
            tabDeux[i] = getRandomEntier(0, 3);

        if(tabUn.length!=tabDeux.length)
            isEquals = false;
        else
            for(int i = 0; i<tabUn.length;i++)
                if(tabUn[i]!=tabDeux[i]){
                    isEquals=false;
                    break;
                }

        if(isEquals)
            System.out.println("les tableaux sont égaux");
        else
            System.out.println("les tableaux ne sont pas égaux");

        System.out.println(Arrays.toString(tabUn));
        System.out.println(Arrays.toString(tabDeux));

    }
}
