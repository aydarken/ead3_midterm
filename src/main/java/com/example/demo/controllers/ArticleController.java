package com.example.demo.controllers;


import com.example.demo.models.Article;
import com.example.demo.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/articles")
    public String getAllPosts() {
       articleService.getAllArticles();
        return "articles";
    }

    @GetMapping(value = "/articles/{id}")
    public Optional<Article> getArticle(@PathVariable long id) {
        return articleService.getArticle(id);
    }

    @PostMapping(value = "/articles/create")
    public void addArticle(@RequestBody Article article) {
        articleService.addArticle(article);
    }

    @PutMapping(value = "/articles/update/{id}")
    public void updateArticle(@PathVariable long id, @RequestBody Article article) {
        articleService.updateArticle(id, article);
    }

    @DeleteMapping(value = "/articles/delete/{id}")
    public void deleteArticle(@PathVariable long id) {
        articleService.deleteArticle(id);
    }
}
