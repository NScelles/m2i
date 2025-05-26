package org.example.tppapetrie.article;

public abstract class Article {
    protected int ref;
    protected static int compt = 1;
    public abstract double getPrix();
    public abstract String affichageFacture(int quantite);

    public Article() {
        this.ref = compt++;
    }


    public Articles getTypeOfArticle(){
        if (this instanceof ArticleUnitaire)
            return Articles.ARTICLEUNITAIRE;
        else
            return Articles.LOT;
    }

    public int getRef() {
        return ref;
    }

    public static int getCompt() {
        return compt;
    }
}
