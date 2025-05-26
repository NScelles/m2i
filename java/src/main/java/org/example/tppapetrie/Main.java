package org.example.tppapetrie;

import org.example.tppapetrie.article.Article;
import org.example.tppapetrie.article.lot.Lot;
import org.example.tppapetrie.article.ramette.Ramette;
import org.example.tppapetrie.article.stylo.CouleurStylo;
import org.example.tppapetrie.article.stylo.Stylo;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Article> articles = new HashMap<>();
        articles.put(Article.getCompt(), new Stylo("Bic",3.99, CouleurStylo.MULTICOLOR));
        Papetrie papetrie = new Papetrie(articles);
        papetrie.ajouterArticle(new Ramette("Oxford",5.99,80));
        Stylo styloBleu = new Stylo("Bic",0.99,CouleurStylo.BLEU);
        papetrie.ajouterArticle(styloBleu);
        papetrie.ajouterArticle(new Lot(styloBleu,10,50));
        System.out.println(Papetrie.getLesArticles());

        String client = "Noa";

        papetrie.nouvelleFacture(client);
        papetrie.ajouterArticleFacture(
                Papetrie.getLastFactureByNom(client).getNumeroFacture(),
                Papetrie.getArticleById(1).getRef(),
                3
                );
        System.out.println(Papetrie.getFactureById(1));

        papetrie.ajouterArticleFacture(
                Papetrie.getLastFactureByNom(client).getNumeroFacture(),
                Papetrie.getArticleById(4).getRef(),
                5
                );
        System.out.println(Papetrie.getFactureById(1));
    }
}
