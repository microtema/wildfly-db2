package de.seve.fate.article.dao;

import de.seve.fate.article.model.Article;
import de.seve.fate.article.model.ArtikleSize;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Mario on 19.03.2016.
 */
public class ArticleDAO {

    private static final Logger LOGGER = Logger.getLogger(ArticleDAO.class.getName());

    @PersistenceContext(unitName = "db2")
    private EntityManager em;

    public List<Article> getArticles(int maxResults) {

        Query nativeQuery = em.createNamedQuery(Article.FIND_ALL);

        nativeQuery.setMaxResults(maxResults);

        return nativeQuery.getResultList();
    }
}
