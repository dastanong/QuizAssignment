package com.example.quiz.repositories;

import java.util.List;

import com.example.quiz.entities.Answer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AnswerRepository
 */
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> findByUserId(Long userId);
    List<Answer> findByQuestionId(Long questionId);
}