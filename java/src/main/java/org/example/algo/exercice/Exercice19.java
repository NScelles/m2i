package org.example.algo.exercice;

public class Exercice19 {
    public static void main(String[] args) {
        int[] tab = new int[10];
        for(int i=0;i<10;i++)
            tab[i]= (int) Math.round(Math.random()*100);
        System.out.println(tab[8]);
    }

}