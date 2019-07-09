package com.example.quiz.controllers;

import java.util.List;

import com.example.quiz.entities.Answer;
import com.example.quiz.entities.Question;
import com.example.quiz.repositories.AnswerRepository;
import com.example.quiz.repositories.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * QuestionController
 */
@RestController
@RequestMapping(path="/api")
public class QuestionController {

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    AnswerRepository answerRepository;

    @PostMapping(value="/questions")
    public void addQuestion(@RequestBody Question question) {
        questionRepository.save(question);
    }

    @GetMapping(value="/questions", produces="application/json")
    public List<Question> searchQuestion(@RequestParam("descriptions") String descriptions) {
        List<Question> questions = questionRepository.findByDescriptionContaining(descriptions);

        if(questions.size() > 1) {
            return questions;
        } else {
            return questionRepository.findAll();
        }
    }

    @GetMapping(value="/questions/{id}/answers", produces="application/json")
    public List<Answer> getAllAnswers(@PathVariable("id") Long questionId) {
        List<Answer> answers = answerRepository.findByQuestionId(questionId);

        return answers;
    }
}