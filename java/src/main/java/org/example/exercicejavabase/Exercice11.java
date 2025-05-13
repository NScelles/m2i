package org.example.exercicejavabase;

import java.util.Locale;

import static org.example.outils.Outils.getChar;
import static org.example.outils.Outils.getString;

public class Exercice11 {
    public static void main(String[] args) {
        char caractere = getChar("Saisir un caractère : ");
        String reponse;
        if(!(caractere>='A' && caractere <='Z' || caractere >='a' && caractere<='z'))
            System.out.println("Ce n'est pas une lettre");
        else {
            reponse = (caractere == 'A' || caractere == 'a' || caractere == 'E' || caractere == 'e' || caractere == 'I' || caractere == 'i' || caractere == 'O' || caractere == 'o' || caractere == 'U' || caractere == 'u' || caractere == 'Y' || caractere == 'y') ?
                    "voyelle" : "consonne";
            System.out.println("Le caractère saisi est une " + reponse);
        }
    }
}
