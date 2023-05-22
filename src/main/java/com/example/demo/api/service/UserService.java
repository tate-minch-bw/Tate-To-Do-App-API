package com.example.demo.api.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.api.model.User;

@Service
public class UserService {
    private List<User> userList;

    //constructor
    public UserService(){
        userList = new ArrayList<>();
        User user1 = new User(0, "John", "John@gmail.com");
        User user2 = new User(1, "Jeff", "Jeff@gmail.com");
        User user3 = new User(2,"Steve", "Steve@gmail.com");
        
        userList.addAll(Arrays.asList(user1,user2,user3));
    }

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