package com.example.quiz.repositories;

import com.example.quiz.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

    
}