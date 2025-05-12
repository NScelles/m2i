package org.example.exercicejavabase;

import java.util.Locale;

import static org.example.outils.Outils.capitalize;
import static org.example.outils.Outils.getString;

public class exercice6 {
    public static void main(String[] args) {
        String myString = getString("Saisir une chaine de caractère: ");
        // Q.1
        System.out.println(myString.toLowerCase());
        // Q.2
        System.out.println(myString.toUpperCase());
        // Bonus 1
        char[] charTab = myString.toCharArray();
        int compt = 1;
        for (char charactere : charTab){
            if (charTab.length == compt)
                System.out.print(charactere + "\n");
            else
                System.out.print(charactere + ",");
            compt++;
        }
        // Bonus 2

        for (String s : myString.split(" ")) {
            String firstLetter = s.substring(0, 1).toUpperCase();
            String last = s.substring(1).toLowerCase();
            System.out.print(firstLetter + last + " ");
        }
    }
}
