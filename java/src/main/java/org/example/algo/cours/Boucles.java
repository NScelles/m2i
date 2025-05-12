package org.example.algo.cours;

import java.util.Scanner;

public class Boucles {
    public static void main(String[] args) {
        /// Boucle Tant Que - while
        int compteur = 1;
        while(compteur<11){
            System.out.println("Compteur: "+ compteur++);
        }
        /// Boucle infini
        Scanner scanner = new Scanner(System.in);
        int nbr=0;
        while (true){
            System.out.println("Saisir le résultat de 2+1 pour sortir de la boucle : ");
            nbr = scanner.nextInt();
            if(nbr == 3) break;
        }


        int som,i;
        i=1;
        som=0;
        while (som<=100){
            som += i;
            i++;
            System.out.println("somme à "+i +" = "+som);
        }
        System.out.println("compteur: " + i);

        /// Do While
        int cmpt=10;
        do{
            System.out.println("compteur : " + cmpt);
            cmpt--;
        }while (cmpt>0);

        /// Casser une boucle : break;
        /// Passer à la prochaine boucle : continue

        for(int cpt=0;cpt<11;cpt++) {
            if(cpt==3)
                continue;
            if(cpt==8)
                break;
            System.out.println(cpt);
        }

    }
}
