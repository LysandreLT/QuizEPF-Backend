package com.example.quizepf_backend.controler;

import com.example.quizepf_backend.DTO.QuizDto;
import com.example.quizepf_backend.models.Quiz;
import com.example.quizepf_backend.services.QuizServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RequestMapping("quizzes")
@RestController
@RequiredArgsConstructor
public class QuizController {
    private final QuizServices quizService;

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id) {
        return quizService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        quizService.deleteById(id);
    }

    @PostMapping("")
    public void addUser(@RequestBody QuizDto quizDto) {
        quizService.addQuiz(quizDto);
    }

    @PostMapping("/{id}")
    public void updateUser(@RequestBody QuizDto quizDto, @PathVariable Long id) {
        quizService.updateQuiz(quizDto, id);
    }

    @GetMapping("")
    public List<Quiz> getUsers() {
        return quizService.findAll();
    }
}
