package org.example.javapoo.exerciceentreprise;

import static org.example.outils.Outils.getEntier;
import static org.example.outils.Outils.getString;

public class IHMConsole {
    private Annuaire annuaire;

    public IHMConsole() {
        this.annuaire = new Annuaire();
    }

    public void demarrer() {
        int choix;
        System.out.println("\nBienvenue sur l'annuaire d'entreprise :");
        do {
            afficheMenu();
            choix = getEntier("Choix : ");
            faireChoixUtilisateur(choix);
        } while (choix != 4);
    }

    private void afficheMenu(){
        System.out.println("1) Ajouter une entreprise");
        System.out.println("2) Voir toutes les entreprises (leurs noms)");
        System.out.println("3) Voir les détails d'une entreprise");
        System.out.println("4) Quitter");
    }

    private void faireChoixUtilisateur(int choix){
        switch (choix) {
            case 1-> ajouterEntreprise();
            case 2-> afficherNomsEntreprises();
            case 3-> voirDetailsEntreprise();
            case 4-> System.out.println("Au revoir !");
            default-> System.out.println("Choix invalide.");
        }
    }

    private void voirDetailsEntreprise() {
        if(annuaire.getEntreprises().size()>0) {
            int idEntreprise = getEntier("Donnez l'ID de l'entreprise");
            while (idEntreprise >= this.annuaire.getEntreprises().size())
                idEntreprise = getEntier("Votre saisie est incorect ");
            System.out.println(this.annuaire.afficheEntrepriseId(idEntreprise));
        } else
            System.out.println("Vous n'avez pas entreprise dans l'annuaire!");
    }



    private void afficherNomsEntreprises() {
        if(annuaire.getEntreprises().size()>0) {
            this.annuaire.afficheToutesEntreprises();
        } else
            System.out.println("Vous n'avez pas entreprise dans l'annuaire!");
    }

    private void ajouterEntreprise() {
        this.annuaire.ajouter(new Entreprise(
                getString("Quel est le nom de l'entreprise: "),
                getString("Quel est son n° de siret : "),
                getString("Ou se situe l'entreprise: "),
                getString("Enfin, donnez l'adresse du siteweb")
        ));
    }

}
