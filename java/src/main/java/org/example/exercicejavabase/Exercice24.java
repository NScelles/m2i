package org.example.exercicejavabase;

import static org.example.outils.Outils.getEntier;

public class Exercice24 {
    public static void main(String[] args) {
        int nbr=getNbr();
        if (isPrime(nbr))
            System.out.println(nbr + " est un nombre premier");
        else
            System.out.println(nbr + " n'est pas un nombre premier");
    }

    public static int getNbr(){
        int rslt;
        while ((rslt=getEntier("Saisir un nombre ( > 1) :"))<=1)
            System.out.println("Ce nombre n'est pas valide");
        return rslt;
    }

    public static boolean isPrime(int nbr){
        boolean isPrime=true;
        for(int i=2;i<=nbr/2;i++)
            if(nbr%i==0)
                isPrime=false;
        return isPrime;
    }
}
