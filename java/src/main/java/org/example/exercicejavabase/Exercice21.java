package org.example.exercicejavabase;

public class Exercice21 {
    public static void main(String[] args) {
        double taux = 0.89/100 + 1,
                nbHabitant = 96809,
                nbAnnee=  Math.ceil((Math.log(120000/nbHabitant))/(Math.log(taux)));

        //System.out.println("nombre d'année nécessaire "+ Math.ceil((Math.log(120000/nbHabitant))/(Math.log(taux))));
        System.out.println("La population de Tourcoing dépassera les 120 000 habitants en "+ (2015+ (int) nbAnnee)+" pour environ "+Math.round(nbHabitant*Math.pow(taux,nbAnnee)+1)+" habitants");
    }
}
