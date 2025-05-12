package org.example.javapoo;

public class WaterTank {
    double poidVide;
    double capaciteMax;
    double niveauRemplissage;
    double totalStoque;

    public WaterTank(double poidVide, double capaciteMax, double niveauRemplissage) {
        this.poidVide = poidVide;
        this.capaciteMax = capaciteMax;
        this.niveauRemplissage = niveauRemplissage;
        this.totalStoque=niveauRemplissage;
    }

    public void remplir(double quantite){
        double res = niveauRemplissage;
        this.niveauRemplissage+=quantite;
        if (quantite+this.niveauRemplissage>this.capaciteMax)
            this.niveauRemplissage= capaciteMax;
        this.totalStoque += this.niveauRemplissage-res;

    }

    public void vider(double quantite){
        this.niveauRemplissage+=quantite;
        if (quantite+this.niveauRemplissage<0)
            this.niveauRemplissage=0;
    }




    public double getNiveauRemplissage() {
        return niveauRemplissage;
    }

    public void setNiveauRemplissage(double niveauRemplissage) {
        this.niveauRemplissage = niveauRemplissage;
    }

    public double getPoidVide() {
        return poidVide;
    }

    public void setPoidVide(double poidVide) {
        this.poidVide = poidVide;
    }

    public double getCapaciteMax() {
        return capaciteMax;
    }

    public void setCapaciteMax(double capaciteMax) {
        this.capaciteMax = capaciteMax;
    }

}
