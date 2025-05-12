package org.example.outils;

import java.util.Scanner;

public class Outils {

    public static void main(String[] args) {
        for (int i = 0;i<100;i++)
            System.out.println(getRandomEntier(0,100));
    }

    public static String getString(String demande){
        Scanner scanner = new Scanner(System.in);
        System.out.println(demande);
        return scanner.nextLine();
    }

    public static int getRandomEntier(int min, int max){
        int resultat = (int) (Math.random() * max);
        while (resultat<min || resultat>max)
            resultat = (int) (Math.random() * max);
        return resultat;
    }

    public static double getRandomDouble(int min, int max){
        double resultat = (Math.random() * max);
        while (resultat<min || resultat>max)
            resultat = (Math.random() * max);
        return resultat;
    }

    public static int getEntier(String demande) {
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

    public static double getReel(String demande) {
        double reel = 0;
        boolean nombreValide = false;
        do {
            try {
                System.out.println(demande);
                reel = new Scanner(System.in).nextDouble();
                nombreValide=true;
            } catch (Exception e){
                System.out.println("La valeur rentrée n'est pas valide");
            };
        }while (!nombreValide);
        return reel;
    }

    public static String capitalize(String inputString) {
        String firstLetter = inputString.substring(0,0);
        return inputString.replaceFirst(firstLetter, firstLetter.toUpperCase());
    }

}
