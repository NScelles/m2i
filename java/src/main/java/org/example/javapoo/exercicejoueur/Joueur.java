package org.example.javapoo.exercicejoueur;

public class Joueur {
    private String nom;
    private int exp;
    private int niv;

    public int getNiv() {
        return niv;
    }

    public void setNiv(int niv) {
        this.niv = niv;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public Joueur() {
        this.nom = "Name";
        this.exp = 0;
        this.niv = 1;
    }

    public Joueur(String nom) {
        this.nom = nom;
        this.exp = 0;
        this.niv = 1;
    }

    public void effectuerUneQuete(int numero) {
        this.exp+=10;
        if (this.isLevelUp())
            levelUp();
        System.out.println("Le joueur "+this.nom+" effectue la quête n°"+numero);
    }

    public void changeNom(String nouvNom){
        System.out.println(this.nom + " change de pseudo : " + (this.nom = nouvNom));
    }

    public void afficheNiv(){
        System.out.println(this.nom + " est niveau "+ this.niv);
    }

    private void levelUp(){
        this.niv++;
        this.exp=0;
        System.out.println("Le joueur " + this.nom + " passe au niveau : " + this.niv);
    }

    private boolean isLevelUp(){
        return this.exp >= 100;
    }


}
