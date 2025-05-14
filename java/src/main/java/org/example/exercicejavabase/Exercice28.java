package org.example.exercicejavabase;

public class Exercice28 {
    public static void main(String[] args) {
        final int N = 100;
        int[] tab= new int[N];
        for (int i=0;i<tab.length;i++)
            tab[i]=i;
        for (int i=0;i<tab.length;i++) {
            if ((i + 1) % 10 == 0)
                System.out.print(i + "\n");
            else
                System.out.print(i + ", ");
        }
    }
}
