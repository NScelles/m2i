package org.example.javapoo.exercicewatertank;

public class WaterTank {
    private double poidVide;
    private double capaciteMax;
    private double niveauRemplissage;
    private static double totalStoque = 0;

    public WaterTank(double poidVide, double capaciteMax, double niveauRemplissage) {
        this.poidVide = poidVide;
        this.capaciteMax = capaciteMax;
        this.niveauRemplissage = niveauRemplissage;
        this.totalStoque+=niveauRemplissage;
    }

    public void remplir(double quantite){
        if (quantite+this.niveauRemplissage>this.capaciteMax && quantite>=0) {
            System.out.println("Vous avez un exedant de " + (this.capaciteMax - (quantite + this.niveauRemplissage)) + "L");
            quantite = this.capaciteMax - this.niveauRemplissage;
        }
        this.niveauRemplissage+=quantite;
        this.totalStoque += quantite;
    }

    public void vider(double quantite){
        if (quantite<this.niveauRemplissage && quantite>=0) {
            System.out.println("Vous avez seulement " + this.niveauRemplissage + "L");
            quantite = this.niveauRemplissage;
        }
        this.niveauRemplissage-=quantite;
        this.totalStoque -= quantite;
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

    public static double getTotalStoque() {
        return totalStoque;
    }

    public static void setTotalStoque(double totalStoque) {
        WaterTank.totalStoque = totalStoque;
    }

    public double getPoidCiterne(){
        return this.poidVide + this.niveauRemplissage;
    }

}
