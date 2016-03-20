package de.seve.fate.article.dao;

import de.seve.fate.article.model.Article;
import de.seve.fate.article.model.LvsArticle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Mario on 19.03.2016.
 */
public class LvsArticleDAO {

    private static final Logger LOGGER = Logger.getLogger(LvsArticleDAO.class.getName());

    @PersistenceContext(unitName = "db2")
    private EntityManager em;


    public void saveOrMergeArticles(Collection<LvsArticle> lvsArticles) {
        LOGGER.info(String.format("save or update <%s> lvsArticles", lvsArticles.size()));

        lvsArticles.stream().filter((article -> article.getId() == null)).forEach(em::persist);

        lvsArticles.stream().filter((article -> article.getId() != null)).forEach(em::merge);
    }

    public LvsArticle find(Article article) {

        if (article.getId() == null) {
            return null;
        }

        return em.find(LvsArticle.class, article.getId());
    }

}
