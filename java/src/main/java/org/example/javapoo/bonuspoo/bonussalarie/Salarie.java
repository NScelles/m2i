package org.example.javapoo.bonuspoo.bonussalarie;

public class Salarie {
    private String matricule;
    private Service service;
    private String nom;
    private double salaire;

    private static double totalSalaire = 0;
    private static int totalSalarie = 0;

    public Salarie(String nom) {
        this("1",Service.DEVELOPPEMENT,nom,12000);
    }

    public Salarie(String matricule, Service service, String nom, double salaire) {
        this.matricule = matricule;
        this.service = service;
        this.nom = nom;
        this.salaire = salaire;
        totalSalarie+=1;
        totalSalaire+=salaire;
    }

    public void afficherSalaire(){
        System.out.println("Le salaire de "+ nom + " est de " + salaire + "€");
    }

    public static void virerToutLeMonde(){
        totalSalarie = 0;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public static double getTotalSalaire() {
        return totalSalaire;
    }

    public static void setTotalSalaire(double totalSalaire) {
        Salarie.totalSalaire = totalSalaire;
    }

    public static int getTotalSalarie() {
        return totalSalarie;
    }

    public static void setTotalSalarie(int totalSalarie) {
        Salarie.totalSalarie = totalSalarie;
    }

    @Override
    public String toString() {
        return "Salarie{" +
                "matricule='" + matricule + '\'' +
                ", service=" + service +
                ", nom='" + nom + '\'' +
                ", salaire=" + salaire +
                "}\n";
    }
}
