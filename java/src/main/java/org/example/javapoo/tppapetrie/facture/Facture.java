package org.example.javapoo.tppapetrie.facture;

import org.example.javapoo.tppapetrie.Papetrie;
import org.example.javapoo.tppapetrie.article.Article;

import java.util.*;

public class Facture {
    private String client;
    private int nbLigneMax;
    private int numeroFacture;
    private Date date;
    private List<Ligne> quantiteLigneAchat;

    private static int comtp = 1;


    public Facture(String client, int numeroFacture) {
        this(client,10,numeroFacture);
    }

    public Facture(String client, int nbLigneMax, int numeroFacture) {
        this.client = client;
        this.nbLigneMax = nbLigneMax;
        this.numeroFacture = comtp++;
        this.date = new Date();
        this.quantiteLigneAchat = new ArrayList<>();
        //toutesLesFactures.put(numeroFacture,this);
    }

    public void ajouterLigne(int ref, int quantite){
        quantiteLigneAchat.add(new Ligne(Article.getArticleByRef(ref),quantite));
    }
    public double getPrixTotal(){
        double prixTotal = 0;
        for (Ligne ligne:quantiteLigneAchat)
            prixTotal+=ligne.getPrix();
        return prixTotal;
    }
}
