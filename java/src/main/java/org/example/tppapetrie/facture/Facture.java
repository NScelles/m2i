package org.example.tppapetrie.facture;

import org.example.tppapetrie.Papetrie;

import java.util.*;

public class Facture {
    private String client;
    private int nbLigneMax;
    private int numeroFacture;
    private Date date;
    private List<Ligne> quantiteLigneAchat;

    private static int comtp = 1;


    public Facture(String client) {
        this(client,10);
    }

    public Facture(String client, int nbLigneMax) {
        this.client = client;
        this.nbLigneMax = nbLigneMax;
        this.numeroFacture = comtp++;
        this.date = new Date();
        this.quantiteLigneAchat = new ArrayList<>();
        //toutesLesFactures.put(numeroFacture,this);
    }


    public void ajouterLigne(int ref, int quantite){
        if (nbLigneMax>quantiteLigneAchat.size())
            quantiteLigneAchat.add(new Ligne(Papetrie.getArticleById(ref),quantite));
        else
            System.out.println("La Facture ne peux pas avoir plus d'articles");
    }
    public double getPrixTotal(){
        double prixTotal = 0;
        for (Ligne ligne:quantiteLigneAchat)
            prixTotal+=ligne.getPrix();
        return prixTotal;
    }

    public static int getComtp() {
        return comtp;
    }

    public String getClient() {
        return client;
    }

    public int getNumeroFacture() {
        return numeroFacture;
    }

    @Override
    public String toString() {
        String afficheLignes="\nquantité | ref | nom | prixU | prix\n";
        for (Ligne ligne:quantiteLigneAchat)
                afficheLignes+= "\n" + ligne.afficheLigne();
        return "Facture:" + "\n" +
                "client: " + client + " | " +
                "numeroFacture: " + numeroFacture + " | " +
                "date: " + date + " | " +
                "articles : " +
                afficheLignes +
                "\nPrix TTC : " + getPrixTotal()
                ;
    }
}
