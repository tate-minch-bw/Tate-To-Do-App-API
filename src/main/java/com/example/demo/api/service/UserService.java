package com.example.demo.api.service;

// import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.api.model.User;
// import com.example.demo.api.repository.TaskRepository;
import com.example.demo.api.repository.UserRepository;
import com.example.demo.api.model.Task;

@Service
public class UserService {
    private List<User> userList;
    @Autowired
    private UserRepository userRepository;
    // @Autowired
    // private TaskRepository taskRepository;

    public void createUser(User user){
        userRepository.save(user);
    }

    public void createTask(Task task, Long userId){
        User user = userRepository.findById(userId).orElseThrow();
        user.getTasks().add(task);
        userRepository.save(user);
    }

    public User getUser(Long userId){
        return userRepository.findById(userId).orElseThrow();
    }

    // public List<Task> getTasks(Long userId){
    //     User user = userRepository.findById(userId).orElseThrow();
    //     return user.getTasks();
    //     return taskRepository.findByUser(user);
    // }


    public User getUser(Integer id){
        for(int i = 0; i < userList.size(); i++){
            if(userList.get(i).getId() == id){
                return userList.get(i); 
            }  
        }
        throw new IllegalArgumentException("Invalid ID");
    }

    public List<User> getUsers(){
        return userList;
    }

}