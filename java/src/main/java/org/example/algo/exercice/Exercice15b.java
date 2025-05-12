package org.example.algo.exercice;

public class Exercice15b {
    public static void main(String[] args) {
          double taux = 0.89/100 + 1,
              nbHabitant = 96809;
//        int compt=0;
//        for (compt=1;nbHabitant<120000;compt++) {
//            System.out.println(nbHabitant);
//            nbHabitant *= 1 + taux;
//        }
        System.out.println("nombre d'année nécessaire "+ Math.ceil((Math.log(120000/nbHabitant))/(Math.log(taux))));


    }
}
