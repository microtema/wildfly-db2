package de.seve.fate.article.batch;

import de.seve.fate.article.model.Article;
import de.seve.fate.article.service.ArticleService;

import javax.batch.api.chunk.ItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * Created by Mario on 19.03.2016.
 */
@Named("ArticleReader")
public class ArticleReader implements ItemReader {

    private static final Logger LOGGER = Logger.getLogger(ArticleReader.class.getName());

    @Inject
    private ArticleService service;

    @Inject
    private JobContext context;

    private int maxResults;

    private Iterator<Article> iterator;

    public void open(Serializable serializable) throws Exception {
        LOGGER.info("get Articles from DB");

        maxResults = Integer.valueOf(context.getProperties().getProperty("max-results"));

        iterator = service.getArticles(maxResults).iterator();
    }

    public void close() throws Exception {
        LOGGER.info("close");
    }

    public Object readItem() throws Exception {

        if (iterator.hasNext()) {
            return iterator.next();
        }

        return null; //end of chunk
    }

    public Serializable checkpointInfo() throws Exception {
        return null;
    }
}
