package org.example.algo.exercice;

import org.example.outils.Outils;

import static org.example.outils.Outils.getReel;

public class Exercice17 {
    public static void main(String[] args) {
        double repUtilsateur=getReel("Donnez une première note"), max = repUtilsateur, min = repUtilsateur, moy = repUtilsateur;
        int compt=1;
         do{
            System.out.println("""
                    1-La plus petite note
                    2-La plus grande note
                    3-La moyenne des notes
                    4-Saisir une note
                    0-Quitter
                    Votre choix : 
                    """
            );
             repUtilsateur= Outils.getEntier("Réponse:");
             switch ((int) repUtilsateur) {
                 case 1 -> System.out.println("La plus petite note tapé est " + min);
                 case 2 -> System.out.println("La plus grande note tapé est " + max);
                 case 3 -> System.out.printf("La moyenne des notes est %.2f\n", moy / compt);
                 case 4 -> {
                     repUtilsateur = getReel("Donnez une note");
                     if (repUtilsateur > max) max = repUtilsateur;
                     if (repUtilsateur < min) min = repUtilsateur;
                     moy += repUtilsateur;
                     compt++;
                     repUtilsateur=7;
                 }
                 case 0 -> System.out.println("end");
                 default -> System.out.println("Erreur dans la saisie");
             }
        }while(repUtilsateur!=0);
    }


}
