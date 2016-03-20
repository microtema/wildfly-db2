package de.seve.fate.article.converter;

import de.seve.fate.article.model.Article;
import de.seve.fate.article.model.LvsArticle;

/**
 * Created by Mario on 20.03.2016.
 */
public class ArticleToLvsArticleConverter implements ModelConverter<LvsArticle, Article> {

    @Override
    public LvsArticle convert(Article article) {

        if (article == null) {
            return null;
        }

        LvsArticle lvsArticle = new LvsArticle();

        update(lvsArticle, article);

        return lvsArticle;
    }

    @Override
    public void update(LvsArticle lvsArticle, Article article) {

        if (article == null) {
            return;
        }

        lvsArticle.setSize(article.getSize());
        lvsArticle.setUrn(article.getUrn());
        lvsArticle.setSuffix(article.getSuffix());
        lvsArticle.setPrefix(article.getPrefix());
        lvsArticle.setSaison(article.getSaison());
    }
}
