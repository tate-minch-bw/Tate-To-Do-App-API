package com.example.demo.api.controller;

import com.example.demo.api.model.Task;
import com.example.demo.api.model.User;
import com.example.demo.api.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId) {
        User user = userService.getUser(Integer.valueOf(userId));
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> listOfUsers = userService.getUsers();
        return listOfUsers.size() != 0 ? ResponseEntity.ok(listOfUsers) : ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/user")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return createdUser != null ? ResponseEntity.ok(createdUser) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/user/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable String userId) {
        User deletedUser = userService.deleteUser(Integer.valueOf(userId));
        return deletedUser != null ? ResponseEntity.ok(deletedUser) : ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/user/{userId}/task")
    public ResponseEntity<Task> createTask(@RequestBody Task task, @PathVariable String userId) {
        Task createdTask = userService.createTask(task, Integer.valueOf(userId));
        return createdTask.getUser() != null ? ResponseEntity.ok(createdTask) : ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/user/{userId}/tasks")
    public ResponseEntity<List<Task>> getTasks(@PathVariable String userId) {
        List<Task> userTasks = userService.getTasks(Integer.valueOf(userId));
        return userTasks.size() != 0 ? ResponseEntity.ok(userTasks) : ResponseEntity.notFound().build();
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

    @PutMapping(value = "/user/{userId}/task/{taskId}")
    public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathVariable String taskId){
        Task updatedTask = userService.updateTask(task, Integer.valueOf(taskId));
        return updatedTask != null ? ResponseEntity.ok(updatedTask) : ResponseEntity.notFound().build();
    }
}