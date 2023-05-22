package com.example.demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.api.model.Task;
import java.util.List;
import com.example.demo.api.model.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // public List<Task> findByUser(User user);
}