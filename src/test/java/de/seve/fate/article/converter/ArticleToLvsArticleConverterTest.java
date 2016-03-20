package de.seve.fate.article.converter;

import org.junit.Test;

import static org.junit.Assert.assertNull;

/**
 * Created by Mario on 20.03.2016.
 */
public class ArticleToLvsArticleConverterTest {

    private ModelConverter sut = new ArticleToLvsArticleConverter();

    @Test
    public void testConvert() throws Exception {
        assertNull(sut.convert(null));
    }

}