package com.example.demo.api.controller;

import com.example.demo.api.model.Task;
import com.example.demo.api.model.User;
import com.example.demo.api.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getMessage() {
        return "<h1>Hello, world!</h1>";
    }

    @GetMapping(value = "/user/{userId}")
    public User getUser(@PathVariable String userId) {
        try {
            return userService.getUser(Integer.valueOf(userId));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    @GetMapping(value = "/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "/user")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @DeleteMapping(value = "/user/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(Integer.valueOf(userId));
    }

    @PostMapping(value = "/user/{userId}/task")
    public void createTask(@RequestBody Task task, @PathVariable String userId) {
        userService.createTask(task, Integer.valueOf(userId));
    }

    @GetMapping(value = "/user/{userId}/tasks")
    public List<Task> getTasks(@PathVariable String userId) {
        return userService.getTasks(Integer.valueOf(userId));
    }

    @GetMapping(value = "/user/{userId}/task/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable String userId, @PathVariable String taskId){
        Task task = userService.getTask(Integer.valueOf(userId),Integer.valueOf(taskId));
        return task != null ?  ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/user/{userId}/task/{taskId}")
    public ResponseEntity<Task> deleteTask(@PathVariable String userId, @PathVariable String taskId){
        Task task = userService.deleteTask(Integer.valueOf(userId),Integer.valueOf(taskId));
        return task != null ? ResponseEntity.ok(task) : ResponseEntity.notFound().build();
    }
    //update task
}