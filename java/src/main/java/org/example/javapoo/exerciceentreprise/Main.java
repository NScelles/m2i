package org.example.javapoo.exerciceentreprise;

import java.util.List;

import static org.example.outils.Outils.getEntier;
import static org.example.outils.Outils.getString;

public class Main {
    public static void main(String[] args) {

        Annuaire annuaire = new Annuaire();
        demarrer(annuaire);

    }

    public static void demarrer(Annuaire annuaire) {
        int choix;
        System.out.println("\nBienvenue sur l'annuaire d'entreprise :");
        do {
            System.out.println("1) Ajouter une entreprise");
            System.out.println("2) Voir toutes les entreprises (leurs noms)");
            System.out.println("3) Voir les détails d'une entreprise");
            System.out.println("4) Quitter");
            choix = choix = getEntier("Choix : ");

            switch (choix) {
                case 1:
                    ajouterEntreprise(annuaire);
                    break;
                case 2:
                    afficherNomsEntreprises(annuaire);
                    break;
                case 3:
                    voirDetailsEntreprise(annuaire);
                    break;
                case 4:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide.");
            }

        } while (choix != 4);
    }

    private static void voirDetailsEntreprise(Annuaire annuaire) {
        int idEntreprise = getEntier("Donnez l'ID de l'entreprise");
        while (idEntreprise>annuaire.getEntreprises().size())
            idEntreprise = getEntier("Votre saisie est incorect ");
        System.out.println(annuaire.afficheEntrepriseId(idEntreprise));
    }

    private static void afficherNomsEntreprises(Annuaire annuaire) {
        annuaire.afficheToutesEntreprises();
    }

    private static void ajouterEntreprise(Annuaire annuaire) {
        annuaire.ajouter(new Entreprise(
                getString("Quel est le nom de l'entreprise: "),
                getString("Quel est son n° de siret : "),
                getString("Ou se situe l'entreprise: "),
                getString("Enfin, donnez l'adresse du siteweb")
        ));
    }

}
