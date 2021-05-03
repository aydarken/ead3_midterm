package com.example.demo;

import com.example.demo.config.SpringConfig;
import com.example.demo.controllers.ArticleController;
import com.example.demo.controllers.UserController;
import com.example.demo.models.Article;
import com.example.demo.models.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ArticleController articleController = context.getBean("articleController", ArticleController.class);
        UserController userController = context.getBean("userController", UserController.class);

        User user = new User();
        user.setName("test");
        user.setEmail("email");
        user.setPassword("test");
        user.setModerator(false);
        userController.addUser(user);

        Article article = new Article();
        article.setNews("test text");
        article.setTitle("test title");
        article.setUser(user);
        article.setUserId(1);

        articleController.addArticle(article);
//        userController.deleteUser(3);



    }
}
