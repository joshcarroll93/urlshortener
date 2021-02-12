package com.assignment.urlshortener.urlshortener.controller;

import com.assignment.urlshortener.urlshortener.model.URLMap;
import com.assignment.urlshortener.urlshortener.URLRepository;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ShortURLController {

    @Autowired
    URLRepository urlRepository;

    private Map<String, URLMap> shortUrlMap = new HashMap<>();

    @RequestMapping(value = "/shorturl", method = RequestMethod.POST)
    public ResponseEntity<Object> addURL(@RequestBody URLMap urlMap){

        UrlValidator urlValidator = new UrlValidator();

        if (urlValidator.isValid(urlMap.originalurl)){

            if(urlExists(urlMap)){
                URLMap um = getUrlFromDb(urlMap);

                return new ResponseEntity<>(um.getShortUrl(), HttpStatus.OK);
            }
            else {
                setShortUrl(urlMap);
                return new ResponseEntity<>(urlMap.getShortUrl(), HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>("URL not valid! try again.", HttpStatus.OK);
        }
    }

    public boolean urlExists(URLMap urlMap){

        List<URLMap> urlList = getUrls();

        for (URLMap map : urlList) {

            if (urlMap.getOriginalUrl().equals(map.getOriginalUrl()))
                return true;
        }
        return false;
    }

    public URLMap getUrlFromDb(URLMap um){
        List<URLMap> urlList = getUrls();

        for (URLMap urlmap : urlList){

            if(urlmap.getOriginalUrl().equals(um.getOriginalUrl()))
                return urlmap;
        }
        return null;
    }

    public void setShortUrl(URLMap URLMap) {

        String shortPath = createShortUrlPath();
        URLMap.setShortUrl("short.url/"+shortPath);
        urlRepository.save(URLMap);
    }

    public String createShortUrlPath(){

        List<URLMap> urlList = getUrls();

        Random randomNumber = new Random();
        int randomResult = randomNumber.nextInt(7000000);

        //check number doesnt exist in db
        for (URLMap url : urlList) {
            System.out.println(url.getId());
            System.out.println(url.getOriginalUrl());
            System.out.println(url.getShortUrl());

            if(url.getShortUrl().equals(String.valueOf(randomResult)))
                createShortUrlPath();

        }
        return String.valueOf(randomResult);
    }

    public List<URLMap> getUrls(){

        List<URLMap> urlList = new ArrayList<>();
        urlRepository.findAll()
                .forEach(urlList::add);

        return urlList;
    }
}
