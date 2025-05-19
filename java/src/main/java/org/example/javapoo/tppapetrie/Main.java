package org.example.javapoo.tppapetrie;

import org.example.javapoo.tppapetrie.article.Article;
import org.example.javapoo.tppapetrie.article.lot.Lot;
import org.example.javapoo.tppapetrie.article.ramette.Ramette;
import org.example.javapoo.tppapetrie.article.stylo.CouleurStylo;
import org.example.javapoo.tppapetrie.article.stylo.Stylo;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Article> articles = new HashMap<>();
        articles.put(Article.getCompt(), new Stylo("Bic",3.99, CouleurStylo.MULTICOLOR));
        Papetrie papetrie = new Papetrie(articles);
        papetrie.ajouterArticle(new Ramette("Oxford",5.99,80));
        papetrie.ajouterArticle(new Lot(new Stylo("Bic",0.99,CouleurStylo.BLEU),10,50));
        System.out.println(papetrie.getLesArticles());
    }
}
