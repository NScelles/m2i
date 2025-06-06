package org.example.tpproduct.dao;

import org.example.tpproduct.models.articles.Article;

import java.lang.invoke.TypeDescriptor;
import java.util.List;

public class ArticleDao extends BaseDao<Article> {
    public ArticleDao() {
        super(Article.class);
    }

    public List<Article> getArticlesByType(Class daughterClass){
        List<Article> articles = session.createQuery("select c from "+daughterClass.getSimpleName()+" c", daughterClass).getResultList();
        for (Article article:articles)
            session.refresh(article);
        return articles;
    }

}
