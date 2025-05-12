package org.example.algo.exercice;

import org.example.outils.Outils;

public class Exercice9 {
    public static void main(String[] args) {
        int poid = Outils.getEntier("Quel est votre poids ?"),
                taille = Outils.getEntier("Quel est votre taille ?");

        if(isTaille1(poid,taille))
            System.out.println("Taille 1");
        else if (isTaille3(poid, taille))
            System.out.println("Taille 3");
        else if(isNotTaille2(poid,taille))
            System.out.println("Pas de taille correspondande");
        else System.out.println("Taille 2");

    }

    private  static boolean isTaille1(int poid,int taille) {
        if (taille <= 160 && poid <= 65)
            return true;
        else if (taille <= 163 && poid <= 59)
            return true;
        else if (taille <= 166 && poid <= 53)
            return true;
        else return taille <= 169 && poid <= 47;
    }
    private  static boolean isTaille3(int poid,int taille) {
        if (taille >= 163 && poid >= 72)
            return true;
        else if (taille >= 172 && poid >= 66)
            return true;
        else if (taille >= 175 && poid >= 60)
            return true;
        else return taille >= 178 && poid >= 54;
    }

    private  static boolean isNotTaille2(int poid,int taille) {
        if (taille >= 172 && poid >= 43)
            return true;
        else if (taille >= 183 && poid >= 48)
            return true;
        else if (taille <= 157 && poid <= 71)
            return true;
        else return taille <= 160 && poid <= 77;
    }
}
