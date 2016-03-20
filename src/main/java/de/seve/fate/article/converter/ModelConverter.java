package de.seve.fate.article.converter;

/**
 * Created by Mario on 20.03.2016.
 */
public interface ModelConverter<D, O> {

    D convert(O article);

    void update(D lvsArticle, O article);
}
