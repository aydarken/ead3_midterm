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

    @RequestMapping(value = "/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/users/{id}")
    public Optional<User> getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public void getUser(@PathVariable long id, @RequestBody User user) {
        userService.updateUser(id, user);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }

    @GetMapping(value = "/profile")
    public void getUserArticles(@PathVariable long id){
        userService.getAllArticlesOfUser(id);
    }

}
