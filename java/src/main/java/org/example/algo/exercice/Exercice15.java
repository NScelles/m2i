package org.example.algo.exercice;

public class Exercice15 {
    public static void main(String[] args) {
        int tailleTable = 10;
        System.out.print(" | x");
        for(int i = 1;i <= tailleTable; i++)
            System.out.print(" | " + i);
        System.out.println();
        for(int i = 1;i <= tailleTable;i++) {
            System.out.print(" | " + i);
            for (int j = 1; j <= tailleTable; j++)
                System.out.print(" | " + i * j);
            System.out.println();
        }
    }
}
