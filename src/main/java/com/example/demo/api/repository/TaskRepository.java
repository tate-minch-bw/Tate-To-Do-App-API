package com.example.demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.api.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Task findByIdAndUserId(Integer taskId, Integer userId);
}