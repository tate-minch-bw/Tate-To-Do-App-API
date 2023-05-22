package com.example.demo.api.controller;

import com.example.demo.api.model.User;

import com.example.demo.api.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getMessage() {
        return "<h1>Hello, world!</h1>";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser(@RequestParam Integer id) {
        try {
            return userService.getUser(id);
        } catch (IllegalArgumentException e){
            return null;
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }
}