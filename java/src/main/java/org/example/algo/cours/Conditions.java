package org.example.algo.cours;

public class Conditions {
    public static void main(String[] args) {
        /// Structure conditionelle

        if(3 > 2){
            System.out.println("3 est supérieur à 2");
        }

        if(4 > 5){
            System.out.println("4 est supérieur à 5");
        }

        double note = 14;
        if(note >= 16){
            System.out.println("très bien");
        } else if(note >= 14){
            System.out.println("Bien");
        } else if(note >= 12){
            System.out.println("Assez Bien");
        } else {
            System.out.println("Bof");
        }

        int choix = 5;
        switch (choix){
            case 1:
                System.out.println("Bonjour");
                break;
            case 2:
                System.out.println("Salut");
                break;
            case 3:
                System.out.println("Bonne Nuit");
                break;
            default:
                System.out.println("=D");
                break;
        }

        switch (choix){
            case 1:
            case 2:
                System.out.println("Salut");
                break;
            case 3:
                System.out.println("Bonne Nuit");
                break;
            default:
                System.out.println("=D");
                break;
        }

        switch (choix){
            case 1 -> System.out.println("Bonjour");
            case 2 -> System.out.println("Salut");
            case 3,4 -> System.out.println("Bonne Nuit");
            default -> System.out.println(" =D");
        }
    }
}
