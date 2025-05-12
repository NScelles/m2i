package org.example.javapoo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(List.of(new Chaise(),new Chaise(),new Chaise()));
        System.out.println(new Film());
        Joueur monJoueur = new Joueur("Noa");
        for(int i=1;monJoueur.getNiv()<100;i++)
            monJoueur.effectuerUneQuete(i);
        monJoueur.afficheNiv();
        monJoueur.changeNom("Mr.Noa");
    }
}
