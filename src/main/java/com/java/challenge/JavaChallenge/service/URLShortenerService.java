package com.java.challenge.JavaChallenge.service;

import com.java.challenge.JavaChallenge.model.URLShortener;
import com.java.challenge.JavaChallenge.repository.URLShortenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class URLShortenerService {
    @Autowired
    private URLShortenerRepository repository;

    public List<URLShortener> listAll(){
        return repository.findAll();
    }

    public void save(URLShortener propuesta){
        repository.save(propuesta);
    }

    public URLShortener findById(Integer id){
        return repository.findById(id).get();
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public URLShortener findByAlias(String alias){
        return repository.findByAlias(alias);
    }

}
