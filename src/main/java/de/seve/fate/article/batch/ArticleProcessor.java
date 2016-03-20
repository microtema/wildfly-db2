package de.seve.fate.article.batch;

import de.seve.fate.article.model.Article;
import de.seve.fate.article.service.LvsArticleService;

import javax.batch.api.chunk.ItemProcessor;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * Created by Mario on 19.03.2016.
 */
@Named("ArticleProcessor")
public class ArticleProcessor implements ItemProcessor {

    private static final Logger LOGGER = Logger.getLogger(ArticleProcessor.class.getName());

    @Inject
    private LvsArticleService service;

    @Override
    public Object processItem(Object article) throws Exception {
        LOGGER.info(String.format("process article:<%s>", article));

        return service.convertArticleToLvsArticle((Article) article);
    }
}
