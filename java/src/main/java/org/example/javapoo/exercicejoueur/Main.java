package org.example.javapoo.exercicejoueur;

public class Main {
    public static void main(String[] args) {
        Joueur monJoueur = new Joueur("Noa");
        for(int i=1;monJoueur.getNiv()<100;i++)
            monJoueur.effectuerUneQuete(i);
        monJoueur.afficheNiv();
        monJoueur.changeNom("Mr.Noa");
    }
}
