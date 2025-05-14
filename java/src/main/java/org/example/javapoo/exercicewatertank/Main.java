package org.example.javapoo.exercicewatertank;

public class Main {
    public static void main(String[] args) {
        WaterTank waterTank1 = new WaterTank(100,300,10);
        WaterTank waterTank2 = new WaterTank(70,200,25);

        System.out.println(" WaterTank 1 volume de départ : " + waterTank1.getNiveauRemplissage());
        System.out.println(" WaterTank 2 volume de départ : " + waterTank2.getNiveauRemplissage());

        System.out.println(" Volume total des WaterTank : " + WaterTank.getTotalStoque());
        waterTank1.remplir(5);
        System.out.println(" Volume total des WaterTank : " + WaterTank.getTotalStoque());
        waterTank1.remplir(60);
        System.out.println(" Volume total des WaterTank : " + WaterTank.getTotalStoque());
        waterTank2.vider(5);
        System.out.println(" Volume total des WaterTank : " + WaterTank.getTotalStoque());
        waterTank2.vider(25);
        System.out.println(" Volume total des WaterTank : " + WaterTank.getTotalStoque());

        System.out.println(" WaterTank 1 volume de départ : " + waterTank1.getNiveauRemplissage());
        System.out.println(" WaterTank 2 volume de départ : " + waterTank2.getNiveauRemplissage());

        System.out.println(" Poids total de la citerne 1 :" + waterTank1.getPoidCiterne());
        System.out.println(" Poids total de la citerne 2 : " + waterTank2.getPoidCiterne());
    }
}
