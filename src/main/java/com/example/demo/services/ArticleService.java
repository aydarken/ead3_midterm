package com.example.demo.services;

import com.example.demo.models.Article;
import com.example.demo.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final String urlArticleApi = "http://newsapi.org/v2/everything?q=tesla&from=2021-02-17&sortBy=publishedAt&apiKey=02fbe27ba8de4322a9399e7890a2b23b";


    @Autowired
    ArticleRepository articleRepository;


    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();

        articleRepository.findAll()
                .forEach(articles::add);
        return articles;
    }

    public Optional<Article> getArticle(long id) {

        return articleRepository.findById(id);
    }

    public void addArticle(Article article) {
        articleRepository.save(article);
    }

    public void updateArticle(long id, Article newArticle) {
        articleRepository.findById(id).map(article -> {
            article.setPublishedTime(newArticle.getPublishedTime());
            article.setTitle(newArticle.getTitle());
            article.setPublisherId(newArticle.getPublisherId());
            article.setNews(newArticle.getNews());
            return article;
        })
                .orElseGet(() -> {
                    newArticle.setId(id);
                    return articleRepository.save(newArticle);

                });

    }

    public void deleteArticle(long id) {
        articleRepository.deleteById(id);
    }

    public void displayArticles(){
//        urlArticleApi
    }

    public List<Optional <Article>> getUserArticles(long id){
        List<Optional<Article>> articlesList = new ArrayList<>();

        articlesList.add(articleRepository.findByPublisherId(id));

        return articlesList;
    }
}
