package org.example.exercicejavabase;



import static org.example.outils.Outils.getEntier;

public class Exercice12 {
    public static void main(String[] args) {
        switch (getEntier(" Saisir un jour de la semaine : ")) {
            case 1 -> System.out.println("Lundi");
            case 2 -> System.out.println("Mardi");
            case 3 -> System.out.println("Mercredi");
            case 4 -> System.out.println("Jeudi");
            case 5 -> System.out.println("Vendredi");
            case 6 -> System.out.println("Samedi");
            case 7 -> System.out.println("Dimanche");
            default -> System.out.println("C'est pas un jour la semaine");
        }
    }
}
