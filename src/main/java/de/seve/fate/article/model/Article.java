package de.seve.fate.article.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Mario on 19.03.2016.
 */
@NamedQueries({
        @NamedQuery(name = Article.FIND_ALL, query = "SELECT a FROm Article a")
})
@Entity
public class Article implements Serializable {

    public static final String FIND_ALL = "Article.findAll";

    @Id
    @GeneratedValue
    private Long id;

    private String saison;

    private Integer prefix;

    private Integer suffix;

    @Enumerated(EnumType.STRING)
    private ArtikleSize size;

    private String urn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public Integer getPrefix() {
        return prefix;
    }

    public void setPrefix(Integer prefix) {
        this.prefix = prefix;
    }

    public Integer getSuffix() {
        return suffix;
    }

    public void setSuffix(Integer suffix) {
        this.suffix = suffix;
    }

    public ArtikleSize getSize() {
        return size;
    }

    public void setSize(ArtikleSize size) {
        this.size = size;
    }


    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = urn;
    }
}
