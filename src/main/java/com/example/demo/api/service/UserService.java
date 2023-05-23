package com.example.demo.api.service;

import com.example.demo.api.model.Task;
import com.example.demo.api.model.User;
import com.example.demo.api.repository.TaskRepository;
import com.example.demo.api.repository.UserRepository;

import org.hibernate.engine.internal.Nullability.NullabilityCheckType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    public User getUser(Integer userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer userId){
        User user = userRepository.findById(userId).orElseThrow();
        userRepository.delete(user);
    }
    
    public List<Task> getTasks(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return user.getTasks();
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

    public void createTask(Task task, Integer userId) {
        User user = userRepository.findById(userId).orElseThrow();
        task.setUser(user);
        taskRepository.save(task);
    }
}