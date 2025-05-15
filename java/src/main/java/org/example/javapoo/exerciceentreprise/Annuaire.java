package org.example.javapoo.exerciceentreprise;

import java.util.ArrayList;
import java.util.List;

public class Annuaire {
    private List<Entreprise> entreprises;

    public Annuaire() {
        this(new ArrayList<>());
    }

    public Annuaire(List<Entreprise> entreprises) {
        this.entreprises = entreprises;
    }

    public void ajouter(Entreprise entreprise){
        entreprises.add(entreprise);
    }

    public Entreprise afficheEntrepriseId(int id){
        return this.entreprises.get(id);
    }

    public void afficheEntrepriseNom(String nom){
        Entreprise entrepriseRecherche;
        for (Entreprise entreprise:this.entreprises)
            if (entreprise.getNom().equals(nom)){
                System.out.println(entreprise);
            }
    }

    public void afficheToutesEntreprises(){
        String affichage = "";
        int compt= 0;
        for (Entreprise entreprise:this.entreprises){
            affichage += "ID : " + (compt++) + " | Nom : " + entreprise.getNom() + "\n";
        }
        System.out.println(affichage);
    }

    public List<Entreprise> getEntreprises() {
        return entreprises;
    }

    public void setEntreprises(List<Entreprise> entreprises) {
        this.entreprises = entreprises;
    }

    @Override
    public String toString() {
        String affichage = "";
        int compt= 0;
        for (Entreprise entreprise:this.entreprises){
            affichage += "ID : " + (compt++) + " | " + entreprise + "\n";
        }
        return affichage;
    }
}
