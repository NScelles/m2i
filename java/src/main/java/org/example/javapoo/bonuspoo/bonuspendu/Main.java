package org.example.javapoo.bonuspoo.bonuspendu;

import static org.example.outils.Outils.getEntier;
import static org.example.outils.Outils.getString;

public class Main {
    public static void main(String[] args) {

        Pendu pendu;

        if(veuxUnNombreEssais())
            pendu = new Pendu(MotsPendu.getMotAlea(),getEntier("Combien voulez-vous d'essais ?"));
        else
            pendu = new Pendu(MotsPendu.getMotAlea());
        System.out.println("Jeu du pendu généré ! Nombre d'essais : " + pendu.getNbEssais());
        do{
            afficheStatusJeu(pendu);
            System.out.println("Veuillez saisir une lettre : ");

        }while (pendu.isWin());

    }

    public static boolean veuxUnNombreEssais(){
        boolean isBonneReponse;
        String reponse = "";
        do {
            reponse = getString("Voulez-vous un nombre d'éssais spécifique (Y/n) ?");
            if (reponse.equals("Y") || reponse.equals("y") || reponse.equals("N") || reponse.equals("n")) {
                isBonneReponse = true;
                System.out.println("Répondez par Y ou n");
            }
            else
                isBonneReponse = false;
        }while (!isBonneReponse);
        return (reponse.equals("Y") || reponse.equals("y"));
    }

    public static void afficheStatusJeu(Pendu pendu){
        System.out.println("Le mot à trouver " + pendu.getMasque() +
                "\n" + "Il vous reste " + pendu.getNbEssais());
    }

}
