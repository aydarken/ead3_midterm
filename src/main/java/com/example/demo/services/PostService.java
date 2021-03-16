package com.example.demo.services;

import com.example.demo.models.Post;
import com.example.demo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();

        postRepository.findAll()
                .forEach(posts::add);
        return posts;
    }

    public Optional<Post> getPost(long id) {

        return postRepository.findById(id);
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public void updatePost(long id, Post newPost) {
        postRepository.findById(id).map(post -> {
            post.setPublishedTime(newPost.getPublishedTime());
            post.setTitle(newPost.getTitle());
            post.setPublisherId(newPost.getPublisherId());
            post.setNews(newPost.getNews());
            return post;
        })
                .orElseGet(() -> {
                    newPost.setId(id);
                    return postRepository.save(newPost);

                });

    }

    public void deletePost(long id) {
        postRepository.deleteById(id);
    }
}
