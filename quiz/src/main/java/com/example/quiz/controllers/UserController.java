package com.example.quiz.controllers;

import java.util.List;

import com.example.quiz.entities.Answer;
import com.example.quiz.entities.Question;
import com.example.quiz.entities.User;
import com.example.quiz.repositories.AnswerRepository;
import com.example.quiz.repositories.QuestionRepository;
import com.example.quiz.repositories.UserRepository;
import com.example.quiz.response_formats.UserSubmissionJson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 */
@RestController
@RequestMapping(path="/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

    @PostMapping(value="/users")
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping(value="/users/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        User existingUser = userRepository.findById(id).orElse(new User());

        if(existingUser.getId() != null) {
            List<Answer> answersOfUser = answerRepository.findByUserId(existingUser.getId());
            answerRepository.deleteAll(answersOfUser);

            List<Question> questionsOfUser = questionRepository.findByUserId(existingUser.getId());
            questionRepository.deleteAll(questionsOfUser);

            userRepository.delete(existingUser);
        }
    }

    @GetMapping(value="/users/{id}/submissions", produces="application/json")
    public UserSubmissionJson showSubmission(@PathVariable Long id) {
        UserSubmissionJson json = new UserSubmissionJson();

        User user = userRepository.findById(id).orElse(new User());
        List<Question> questionsOfUser = questionRepository.findByUserId(user.getId());
        List<Answer> answersOfUser = answerRepository.findByUserId(user.getId());

        json.user = user;
        json.allQuestions = questionsOfUser;
        json.allAnswers = answersOfUser;

        return json;
    }
}