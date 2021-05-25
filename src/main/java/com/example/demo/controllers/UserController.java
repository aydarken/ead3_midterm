package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public Optional<User> getUser(@PathVariable long id) {
        return userService.getUser(id);
    }


    @PostMapping(value = "/users/add")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping(value = "/users/update/{id}")
    public void getUser(@PathVariable long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @DeleteMapping(value = "/users/delete/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @GetMapping(value = "/profile")
    public void getUserArticles(@PathVariable long id){
        userService.getAllArticlesOfUser(id);
    }

}
