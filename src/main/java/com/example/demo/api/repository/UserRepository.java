package com.example.demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.api.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}
