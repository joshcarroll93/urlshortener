package com.assignment.urlshortener.urlshortener.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class URLMap {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    public String originalurl;
    private String shorturl;


    public URLMap(){};

    public URLMap(String originalurl) {
        this.originalurl = originalurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalurl;
    }

    public void setOriginalUrl(String originalurl) {
        this.originalurl = originalurl;
    }

    public String getShortUrl() {
        return shorturl;
    }

    public void setShortUrl(String shortUrl) {
        this.shorturl = shortUrl;
    }

}
