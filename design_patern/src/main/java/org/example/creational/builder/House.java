package org.example.creational.builder;

public class Maison {
    private int nbEtage;
    private boolean piscine;
    private String typeToiture;
    private String couleur;

    @Override
    public String toString() {
        return "Maison{" +
                "nbEtage=" + nbEtage +
                ", piscine=" + piscine +
                ", typeToiture='" + typeToiture + '\'' +
                ", couleur='" + couleur + '\'' +
                '}';
    }

    private Maison(Builder builder) {
        this.nbEtage = builder.nbEtage;
        this.piscine = builder.piscine;
        this.typeToiture = builder.typeToiture;
        this.couleur = builder.couleur;
    }

    public static class Builder {

        public int nbEtage;
        public boolean piscine;
        public String typeToiture;
        public String couleur;

        public Builder nbEtage(int nbEtage){
            this.nbEtage = nbEtage;
            return this;
        }

        public Builder piscine(boolean piscine){
            this.piscine = piscine;
            return this;
        }

        public Builder typeToiture(String typeToiture){
            this.typeToiture = typeToiture;
            return this;
        }

        public Builder couleur(String couleur){
            this.couleur = couleur;
            return this;
        }

        public Maison build(){
            return new Maison(this);
        }
    }
}
