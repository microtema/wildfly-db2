package de.seve.fate.article.batch;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.util.logging.Logger;

/**
 * Created by Mario on 19.03.2016.
 */
@Singleton
@Startup
public class ArticleJobOperator {

    private static final Logger LOGGER = Logger.getLogger(ArticleJobOperator.class.getName());

    private static final String JOB_ID = "article-batch-job";

    private JobOperator operator;

    private Long pid;

    @PostConstruct
    private void start() {
        LOGGER.info(String.format("start Job: <%s>", JOB_ID));

        operator = BatchRuntime.getJobOperator();

        pid = operator.start(JOB_ID, null);

        LOGGER.info(String.format("Job: <%s> has been started", pid));
    }

    @PreDestroy
    private void stop() {

        if (pid != null) {
            LOGGER.info(String.format("stop Job: <%s>", pid));
            operator.stop(pid);
            pid = null;
        } else {
            LOGGER.warning(String.format("Job: <%s> has never been started", pid));
        }
    }
}
