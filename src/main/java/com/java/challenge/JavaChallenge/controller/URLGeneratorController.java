package com.java.challenge.JavaChallenge.controller;

import com.java.challenge.JavaChallenge.model.URLShortener;
import com.java.challenge.JavaChallenge.service.URLShortenerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class URLGeneratorController {

    private Logger logger = LogManager.getLogger(this.getClass());
    @Autowired
    private URLShortenerService service;

    @RequestMapping(value = {"/", "/{alias}"},method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getByAlias(@PathVariable(name = "alias", required = false) String alias){
        logger.debug("alias {}",alias);
        return new ResponseEntity<>("Test", HttpStatus.OK);
    }

    @RequestMapping(value = {"/"},method= RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> setAlias(@RequestBody URLShortener elemento){
        String url = elemento.getUrl();

        URLShortener temp = new URLShortener();
        temp.setUrl(url);
        temp.setAlias("alias");
        service.save(temp);

        return new ResponseEntity<>("Test", HttpStatus.OK);
    }
}
