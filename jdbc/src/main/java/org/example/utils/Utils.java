package org.example.utils;

import java.util.Scanner;

public abstract class Utils {

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
        int multiplicateur = Math.max(Math.abs(max), Math.abs(min));
        int resultat;
         do{
            resultat = (int) (Math.random() * multiplicateur);
            if(min<0 && (int) (Math.random()*10)>5)
                resultat *= -1;
        }while (!(resultat>=min && resultat<=max));
        return resultat;
    }

    public static double getRandomDouble(int min, int max){
        double resultat = (Math.random() * max);
        while (resultat<min || resultat>max)
            resultat = (Math.random() * max);
        return resultat;
    }

    public static int getInt(String demande) {
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

    public static double getDouble(String demande) {
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

    public static char getChar(String demande) {
        char caractere=' ';
        boolean caractereValide = false;
        do {
            try {
                System.out.println(demande);
                caractere = new Scanner(System.in).nextLine().charAt(0);
                caractereValide=true;
            } catch (Exception e){
                System.out.println("La valeur rentrée n'est pas valide");
            };
        }while (!caractereValide);
        return caractere;
    }

    public static String capitalize(String inputString) {
        String firstLetter = inputString.substring(0,1);
        return inputString.replaceFirst(firstLetter, firstLetter.toUpperCase());
    }

}
