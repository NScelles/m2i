package org.example.algo.exercice;

import org.example.outils.Outils;

public class Exercice17b {
    public static void main(String[] args) {
        int n= Outils.getEntier("Donnez un nombre");
        for (int i=1;i<=n;i++) {
            for (int j = 1; j <= i; j++)
                System.out.print(j);
            System.out.println();
        }
        String msg="";
        for (int i=1;i<=n;i++) {
            msg += i;
            System.out.println(msg);
        }

    }

}
