package com.example.demo.api.service;

import com.example.demo.api.model.Task;
import com.example.demo.api.model.User;
import com.example.demo.api.repository.TaskRepository;
import com.example.demo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public void createTask(Task task, Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        task.setUser(user);
        taskRepository.save(task);
    }

    public User getUser(Long userId) {
        return userRepository.findById(userId).orElseThrow();
    }

    public List<Task> getTasks(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return user.getTasks();
    }


    public List<User> getUsers() {
        return userRepository.findAll();
    }
}