package org.example.javapoo.tppapetrie;

import org.example.javapoo.tppapetrie.article.Article;
import org.example.javapoo.tppapetrie.facture.Facture;

import java.util.HashMap;
import java.util.Map;

public class Papetrie {
    private Map<Integer, Article> lesArticles;
    private Map<Integer, Facture> lesFactures;

    public Papetrie() {
        this(new HashMap<>());
    }

    public Papetrie(Map<Integer, Article> lesArticles) {
        this.lesArticles = lesArticles;
        this.lesFactures = new HashMap<>();
    }

    public Article getArticleById(int ref){
        return Article.getArticleByRef(ref);
    }

    public boolean isExist(Integer ref){
        return this.lesArticles.containsKey(ref);
    }

    public void ajouterArticle(Article article){
        lesArticles.put(article.getRef(),article);
    }

    public Map<Integer, Article> getLesArticles() {
        return lesArticles;
    }

    public void setLesArticles(Map<Integer, Article> lesArticles) {
        this.lesArticles = lesArticles;
    }

    public Map<Integer, Facture> getLesFactures() {
        return lesFactures;
    }

    public void setLesFactures(Map<Integer, Facture> lesFactures) {
        this.lesFactures = lesFactures;
    }

    @Override
    public String toString() {
        return "Papetrie{" +
                "lesArticles=" + lesArticles +
                '}';
    }
}
