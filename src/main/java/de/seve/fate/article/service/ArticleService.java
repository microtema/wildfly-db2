package de.seve.fate.article.service;

import de.seve.fate.article.dao.ArticleDAO;
import de.seve.fate.article.model.Article;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mario on 19.03.2016.
 */
@Stateless
public class ArticleService {

    @Inject
    private ArticleDAO dao;

    public List<Article> getArticles(int maxResults) {

        return dao.getArticles(maxResults);
    }
}
