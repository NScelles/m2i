package org.example.javapoo.tppapetrie.article;

import org.example.javapoo.tppapetrie.article.lot.Lot;

public abstract class Article {
    protected int ref;
    protected static int compt = 1;

    public Article(int ref) {
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
