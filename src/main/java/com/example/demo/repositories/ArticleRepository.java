package com.example.demo.repositories;

import com.example.demo.models.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    Optional<Article> findByPublisherId(Long aLong);
}
