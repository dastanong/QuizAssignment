package com.example.quiz.repositories;

import java.util.List;

import com.example.quiz.entities.Question;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * QuestionRepository
 */
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByUserId(Long userId);
    List<Question> findByDescriptionContaining(String description);
}