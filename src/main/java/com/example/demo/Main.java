package com.example.demo;

import com.example.demo.config.SpringConfig;
import com.example.demo.controllers.ArticleController;
import com.example.demo.controllers.UserController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        ArticleController articleController = context.getBean("articleController", ArticleController.class);
        UserController userController = context.getBean("userController", UserController.class);


    }
}
