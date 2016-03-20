package de.seve.fate.article.batch;

import de.seve.fate.article.model.LvsArticle;
import de.seve.fate.article.service.LvsArticleService;

import javax.batch.api.chunk.ItemWriter;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Mario on 19.03.2016.
 */
@Named("LvsArticleWriter")
public class LvsArticleWriter implements ItemWriter {

    private static final Logger LOGGER = Logger.getLogger(LvsArticleWriter.class.getName());

    @Inject
    private LvsArticleService service;


    public void open(Serializable serializable) throws Exception {
        LOGGER.info("open");
    }

    public void close() throws Exception {
        LOGGER.info("close");
    }

    public void writeItems(List list) throws Exception {
        LOGGER.info(String.format("start write <%s> Articles", list.size()));

        service.saveOrMergeLvsArticles((List<LvsArticle>) list);
    }

    public Serializable checkpointInfo() throws Exception {
        return null;
    }

}
