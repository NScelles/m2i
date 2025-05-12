package org.example.algo.exemple;

import java.util.Scanner;

public class Exemple4 {
    public static void main(String[] args) {
        double puiss=1, x = getReel("Donnez x");
        int n = getEntier("Donnez n");
        for (int i = 1;i<=n;i++)
            puiss*=x;
        System.out.println(x+ " à la puissance "+ n+ " est égal à "+ puiss);
    }

    private static int getEntier(String demande) {
        int entier = 0;
        boolean nombreValide = false;
        do {
            try {
                System.out.println(demande);
                entier = new Scanner(System.in).nextInt();
                nombreValide=true;
            } catch (Exception e){
                System.out.println("La valeur rentrée n'est pas valide");
            };
        }while (!nombreValide);
        return entier;
    }

    private static double getReel(String demande) {
        double reel = 0;
        boolean nombreValide = false;
        do {
            try {
                System.out.println(demande);
                reel = new Scanner(System.in).nextInt();
                nombreValide=true;
            } catch (Exception e){
                System.out.println("La valeur rentrée n'est pas valide");
            };
        }while (!nombreValide);
        return reel;
    }
}
