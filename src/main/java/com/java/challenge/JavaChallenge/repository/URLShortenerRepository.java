package com.java.challenge.JavaChallenge.repository;

import com.java.challenge.JavaChallenge.model.URLShortener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface URLShortenerRepository extends JpaRepository<URLShortener,Integer> {
    @Transactional
    @Query(nativeQuery = true, value = "Select * from URLShortener element " +
            "where element.alias = ?1 ")
    URLShortener findByAlias(String alias);
}
