package com.java.challenge.JavaChallenge.controller;

import com.java.challenge.JavaChallenge.model.URLShortener;
import com.java.challenge.JavaChallenge.service.URLShortenerService;
import com.java.challenge.JavaChallenge.util.URLOperations;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class URLGeneratorController {

    private Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    private URLShortenerService service;
    private URLOperations operations = new URLOperations();

    @RequestMapping(value = {"/", "/{alias}"},method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getByAlias(@PathVariable(name = "alias", required = false) String alias){
        logger.debug("alias {}",alias);
        try{
            URI url = new URI("http://www.yahoo.com");
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setLocation(url);
            return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
        } catch (URISyntaxException exc){
            return new ResponseEntity<>("Fallo", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = {"/"},method= RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> setAlias(@RequestBody URLShortener elemento){
        String url = elemento.getUrl();
        if (operations.isValid(url)){
            URLShortener element = service.findByURL(url);

            if (element == null){
                String alias = "";

                if (operations.isGoogle(url)){
                    alias = operations.aliasAlphaGenerator();
                    logger.debug("google {}",alias);
                } else if(operations.isYahoo(url)){
                    alias = operations.aliasAlphaNumericGenerator();
                    logger.debug("yahoo {}",alias);
                } else{
                    alias = operations.aliasCustomGenerator(url);
                    logger.debug("custom {}",alias);
                }

                URLShortener temp = new URLShortener();
                temp.setUrl(url);
                temp.setAlias(alias);
                service.save(temp);
                String nElement = new JSONObject()
                        .put("code",HttpStatus.OK)
                        .put("alias",temp.getAlias())
                        .toString();
                return new ResponseEntity<>(nElement, HttpStatus.OK);
            }
            String aElement = new JSONObject()
                    .put("code",HttpStatus.OK)
                    .put("alias",element.getAlias())
                    .toString();
            return new ResponseEntity<>(aElement, HttpStatus.OK);


        } else{
            String error = new JSONObject()
                    .put("code",HttpStatus.NOT_FOUND)
                    .put("error","El URL no puede estar vacio")
                    .toString();
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}
