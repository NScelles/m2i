package org.example.javapoo.bonuspoo.bonussalarie;

import org.example.javapoo.exercicechaise.Chaise;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Salarie> salaries=List.of(new Salarie("Carlo"),new Salarie("Noa"),new Salarie("Nelson"));
        for (Salarie salarie:salaries)
            salarie.afficherSalaire();
        System.out.println("Le montant total des salaires des "+ Salarie.getTotalSalarie()+ " est de " + Salarie.getTotalSalaire() + "€");
        Salarie.virerToutLeMonde();
        System.out.println("Il y a " + Salarie.getTotalSalarie() + " salarié(s)");
    }
}
