package org.example.javapoo.exerciceentreprise;

public class
Entreprise {
    private String nom;
    private String siret;
    private String adresse;
    private String siteweb;

    public Entreprise(String nom, String siret, String adresse, String siteweb) {
        this.nom = nom;
        this.siret = siret;
        this.adresse = adresse;
        this.siteweb = siteweb;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getSiteweb() {
        return siteweb;
    }

    public void setSiteweb(String siteweb) {
        this.siteweb = siteweb;
    }

    @Override
    public String toString() {
        return  "nom = " + nom  +
                ", siret = " + siret +
                ", adresse = " + adresse  +
                ", siteweb = " + siteweb  ;
    }
}
