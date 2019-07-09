package com.example.quiz.response_formats;

import java.util.List;

import com.example.quiz.entities.Answer;
import com.example.quiz.entities.Question;
import com.example.quiz.entities.User;

/**
 * UserSubmissionJSON
 */
public class UserSubmissionJson {
    public User user;
    public List<Question> allQuestions;
    public List<Answer> allAnswers;
}