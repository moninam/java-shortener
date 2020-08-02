package com.java.challenge.JavaChallenge.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "URL_SHORTENER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class URLShortener {
    @Column(name="id")
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(name="url")
    @JsonProperty("url")
    private String url;

    @Column(name="alias")
    @JsonProperty("alias")
    private String alias;

    public URLShortener() {}

    public URLShortener(Integer id, String url, String alias) {
        this.id = id;
        this.url = url;
        this.alias = alias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
