package org.example.javapoo.bonuspoo.bonuschaise;

import org.example.javapoo.exercicechaise.Materiaux;
import org.example.outils.Outils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.outils.Outils.getRandomDouble;

public class Chaise {
    private int nbrPied;
    private Materiaux materiaux ;
    private Color couleur;
    private double prix;

    private static List<Chaise> totalChaise = new ArrayList<>();

    public Chaise() {
        this(Outils.getRandomEntier(1,5),Materiaux.PLASTIQUE,new Color(0x000000),getRandomDouble(1,100));
    }

    public Chaise(int nbrPied, Materiaux materiaux, Color color, double prix) {
        this.nbrPied = nbrPied;
        this.materiaux = materiaux;
        this.couleur = color;
        this.prix = prix;
        totalChaise.add(this);
    }

    public void CasserPied(int nbrPied){
        if(this.nbrPied - nbrPied>=0) this.nbrPied-=nbrPied;
    }

    public int getNbrPied() {
        return nbrPied;
    }

    public void setNbrPied(int nbrPied) {
        this.nbrPied = nbrPied;
    }

    public Materiaux getMateriaux() {
        return materiaux;
    }

    public void setMateriaux(Materiaux materiaux) {
        this.materiaux = materiaux;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Je suis une chaise avec "+nbrPied+
                " pied(s) en "+materiaux+
                " de couleur "+ couleur +
                " à un prix de " + Math.floor(prix*100)/100+
                "\n";
    }


}
