package com.example.quiz.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Answer
 */
@Entity(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "question_id")
    private Long questionId;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
    
}