package org.example.javapoo.tppapetrie.article;

import org.example.javapoo.tppapetrie.article.lot.Lot;
import org.example.javapoo.tppapetrie.article.ramette.Ramette;
import org.example.javapoo.tppapetrie.article.stylo.Stylo;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;

public abstract class Article {
    protected int ref;
    protected static int compt = 1;
    private static Map<Integer,Article> lesArticles = new HashMap<>();

    public Article() {
        this.ref = compt++;
        lesArticles.put(this.ref,this);
    }

    public static Article getArticleByRef(int ref){
        return lesArticles.get(ref);
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
