package org.example.javapoo.bonuspoo.bonuspendu;

public class Pendu {
    private String masque;
    private String motATrouver;
    private int nbEssais;

    public Pendu(String motATrouver) {
        this(motATrouver,10);
    }

    public Pendu(String motATrouver, int nbEssais) {
        this.motATrouver = motATrouver;
        this.masque = genererMasque(motATrouver);
        this.nbEssais = nbEssais;
    }

    public boolean isWin(){
        return (this.masque.equals(this.motATrouver));
    }

    private boolean estUnBonCaratere(String caratere){
        return this.motATrouver.contains(caratere);
    }

    private String genererMasque(String motATrouver){
        String masque = "";
        for (int i=0;i<motATrouver.length();i++)
            if (Character.isLetter(motATrouver.charAt(i)))
                masque += "_";
            else
                masque += motATrouver.substring(i,i+1);
        return masque;
    }

    public String getMasque() {
        return masque;
    }

    public void setMasque(String masque) {
        this.masque = masque;
    }

    public String getMotATrouver() {
        return motATrouver;
    }

    public void setMotATrouver(String motATrouver) {
        this.motATrouver = motATrouver;
    }

    public int getNbEssais() {
        return nbEssais;
    }

    public void setNbEssais(int nbEssais) {
        this.nbEssais = nbEssais;
    }
}
