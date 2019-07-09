package com.example.quiz.controllers;

import com.example.quiz.entities.Answer;
import com.example.quiz.entities.Question;
import com.example.quiz.repositories.AnswerRepository;
import com.example.quiz.repositories.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AnswerController
 */
@RestController
@RequestMapping(path="/api")
public class AnswerController {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @PostMapping(value="/questions/{id}/answers")
    public void addAnswer(@RequestBody Answer answer, @PathVariable("id") long id) {
        Question question = questionRepository.findById(id).orElse(new Question());

        if(question.getId() != null) {
            answer.setQuestionId(id);
            answerRepository.save(answer);
        }
    }

    @PostMapping(value="/answers/{id}")
    public void updateAnswer(@RequestBody Answer answer, @PathVariable("id") long id) {
        Answer existingAnswer = answerRepository.findById(id).orElse(new Answer());

        if(existingAnswer.getId() != null) {
            answer.setId(id);
            answer.setQuestionId(existingAnswer.getQuestionId());
            answer.setUserId(existingAnswer.getUserId());
            answerRepository.save(answer);
        }
    }
}