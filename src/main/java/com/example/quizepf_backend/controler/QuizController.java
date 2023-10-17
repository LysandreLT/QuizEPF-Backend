package com.example.quizepf_backend.controler;

import com.example.quizepf_backend.DTO.QuizAnswerDto;
import com.example.quizepf_backend.DTO.QuizDto;
import com.example.quizepf_backend.DTO.QuizQuestionDto;
import com.example.quizepf_backend.models.Quiz;
import com.example.quizepf_backend.models.QuizAnswer;
import com.example.quizepf_backend.models.QuizQuestion;
import com.example.quizepf_backend.services.QuizQuestionServices;
import com.example.quizepf_backend.services.QuizServices;
import com.example.quizepf_backend.services.QuizAnswerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RequestMapping("quizzes")
@RestController
@RequiredArgsConstructor
public class QuizController {
    private final QuizServices quizService;
    private final QuizQuestionServices quizQuestionServices;
    private final QuizAnswerServices quizAnswerServices;

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return quizService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable Long id) {
        quizService.deleteById(id);
    }

    @PostMapping("")
    public Quiz addQuiz(@RequestBody QuizDto quizDto) {
        return quizService.addQuiz(quizDto);
    }

    @PostMapping("/{id}")
    public void updateQuiz(@RequestBody QuizDto quizDto, @PathVariable Long id) {
        quizService.updateQuiz(quizDto, id);
    }

    @GetMapping("")
    public List<Quiz> getQuizs() {
        return quizService.findAll();
    }

    // Quizzes questions
    @GetMapping("/questions/{id}")
    public QuizQuestion getQuizQuestionById(@PathVariable Long id) {
        return quizQuestionServices.getById(id);
    }

    @DeleteMapping("/questions/{id}")
    public void deleteQuizQuestion(@PathVariable Long id) {
        quizQuestionServices.deleteById(id);
    }

    @PostMapping("/questions")
    public QuizQuestion addQuizQuestion(@RequestBody QuizQuestionDto quizQuestionDto) {
        return quizQuestionServices.addQuizQuestion(quizQuestionDto);
    }

    @PostMapping("/questions/{id}")
    public void updateQuizQuestion(@RequestBody QuizQuestionDto quizQuestionDto, @PathVariable Long id) {
        quizQuestionServices.updateQuizQuestion(quizQuestionDto, id);
    }

    @GetMapping("/questions")
    public List<QuizQuestion> getQuizQuestions() {
        return quizQuestionServices.findAll();
    }

    // Quizzes Answers


    @GetMapping("/answers/{id}")
    public QuizAnswer getQuizAnswerById(@PathVariable Long id) {
        return quizAnswerServices.getById(id);
    }

    @DeleteMapping("/answers/{id}")
    public void deleteQuizAnswer(@PathVariable Long id) {
        quizAnswerServices.deleteById(id);
    }

    @PostMapping("/answers")
    public void addQuizAnswer(@RequestBody QuizAnswerDto quizAnswerDto) {
        quizAnswerServices.addQuizAnswer(quizAnswerDto);
    }

    @PostMapping("/answers/{id}")
    public void updateQuizAnswer(@RequestBody QuizAnswerDto quizAnswerDto, @PathVariable Long id) {
        quizAnswerServices.updateQuizAnswer(quizAnswerDto, id);
    }

    @GetMapping("/answers")
    public List<QuizAnswer> getQuizAnswers() {
        return quizAnswerServices.findAll();
    }
}
