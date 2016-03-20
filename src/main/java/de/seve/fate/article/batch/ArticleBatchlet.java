package de.seve.fate.article.batch;

import javax.batch.api.Batchlet;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * Created by Mario on 19.03.2016.
 */
@Named("ArticleBatchlet")
public class ArticleBatchlet implements Batchlet {

    private static final Logger LOGGER = Logger.getLogger(ArticleBatchlet.class.getName());


    @Override
    public String process() throws Exception {
        LOGGER.info("process successfully completed");

        return "COMPLETE";
    }

    @Override
    public void stop() throws Exception {
        LOGGER.info("stop");
    }
}
