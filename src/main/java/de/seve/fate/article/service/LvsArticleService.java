package de.seve.fate.article.service;

import de.seve.fate.article.converter.ArticleToLvsArticleConverter;
import de.seve.fate.article.dao.LvsArticleDAO;
import de.seve.fate.article.model.Article;
import de.seve.fate.article.model.LvsArticle;
import de.seve.fate.article.number.generator.ArticleNumberGenerator;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * Created by Mario on 20.03.2016.
 */
@Stateless
public class LvsArticleService {

    private static final Logger LOGGER = Logger.getLogger(LvsArticleService.class.getName());

    @Inject
    private LvsArticleDAO dao;

    @Inject
    private ArticleToLvsArticleConverter converter;

    @Inject
    private ArticleNumberGenerator generator;


    public LvsArticle convertArticleToLvsArticle(Article article) {

        LvsArticle lvsArticle = dao.find(article);

        if (lvsArticle == null) {
            lvsArticle = converter.convert(article);
        }

        converter.update(lvsArticle, article);

        return lvsArticle;
    }

    public void saveOrMergeLvsArticles(Collection<LvsArticle> lvsArticles) {

        lvsArticles.forEach(generator::generate);
        dao.saveOrMergeArticles(lvsArticles);
    }

}
