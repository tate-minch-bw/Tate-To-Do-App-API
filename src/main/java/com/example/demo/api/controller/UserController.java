package com.example.demo.api.controller;

import com.example.demo.api.model.User;

import com.example.demo.api.service.UserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.api.model.Task;

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

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @RequestMapping(value = "/user/{userId}/task", method = RequestMethod.POST)
    public void createTask(@RequestBody Task task, @PathVariable String userId) {
        userService.createTask(task, Long.valueOf(userId));
    }

    @RequestMapping(value = "/user/{userId}/task", method = RequestMethod.GET)
    public List<Task> getTasks(@PathVariable String userId){
        // return userService.getTasks(Long.valueOf(userId));
        User user = userService.getUser(Long.valueOf(userId));
        return user.getTasks();
    }
}