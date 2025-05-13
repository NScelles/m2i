package org.example.exercicejavabase;

import static org.example.outils.Outils.getChar;

public class Exercice15 {
    public static void main(String[] args) {
        char caractere = getChar("Saisir un caractère : ");
        String reponse;
        if(caractere>='A' && caractere <='Z' || caractere >='a' && caractere<='z')
            reponse = " une lettre de l'alphabet";
        else if (caractere>='0' && caractere <='9')
            reponse = " un chiffre";
        else
            reponse = " un caractère spécial";
        System.out.println(caractere + " est " + reponse);
    }
}
