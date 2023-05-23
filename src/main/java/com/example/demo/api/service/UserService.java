package com.example.demo.api.service;

import com.example.demo.api.model.Task;
import com.example.demo.api.model.User;
import com.example.demo.api.repository.TaskRepository;
import com.example.demo.api.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        if(user != null){
            userRepository.save(user);
        }
        return user;
    }

    public User deleteUser(Integer userId){
        User user = userRepository.findById(userId).orElse(null);
        if (user != null){
            userRepository.delete(user);
        }
        return user;
    }
    
    public List<Task> getTasks(Integer userId) {
        List<Task> tasks = new ArrayList<>(0);
        User user = userRepository.findById(userId).orElse(null);
        if(user != null){
            tasks = user.getTasks();
        }
        return tasks;
    }

    public Task getTask(Integer userId, Integer taskId){
        Task task = new Task();
        task = taskRepository.findByIdAndUserId(taskId, userId);
        return task;
    }

    public Task deleteTask(Integer userId, Integer taskId){
        Task task = new Task();
        task = taskRepository.findByIdAndUserId(taskId, userId);
        if(task != null){
            taskRepository.delete(task);
        }
        return task;
    }

    public Task updateTask(Task task, Integer taskId){
        Task updatedTask = taskRepository.findById(taskId).orElse(null);
        if(updatedTask != null){
            updatedTask.setTask(task.getTask());
            taskRepository.save(updatedTask);
        }
        return updatedTask;
    }

    public Task createTask(Task task, Integer userId) {
        User user = userRepository.findById(userId).orElse(null);
        task.setUser(user);
        if(user != null){
            taskRepository.save(task);
        }
        return task;
    }
}