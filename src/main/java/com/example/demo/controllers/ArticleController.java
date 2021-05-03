package com.example.demo.controllers;


import com.example.demo.models.Article;
import com.example.demo.services.ArticleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articlesapi")
@Api(value = "Articles Controller class", description = "This class allows to interact with Articles object")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping(value = "/articles")
    public List<Article> getAllPosts() {
        return articleService.getAllArticles();
    }

    @GetMapping(value = "/articles/{id}")
    public Optional<Article> getArticle(@PathVariable long id) {
        return articleService.getArticle(id);
    }

    @RequestMapping(value = "/articles", method = RequestMethod.POST)
    public void addArticle(@RequestBody Article article) {
        articleService.addArticle(article);
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.PUT)
    public void updateArticle(@PathVariable long id, @RequestBody Article article) {
        articleService.updateArticle(id, article);
    }

    @RequestMapping(value = "/articles/{id}", method = RequestMethod.DELETE)
    public void deleteArticle(@PathVariable long id) {
        articleService.deleteArticle(id);
    }
}
