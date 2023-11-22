package com.example.quizepf_backend.controler;

import com.example.quizepf_backend.DTO.QuizUserDto;
import com.example.quizepf_backend.DTO.Ranking;
import com.example.quizepf_backend.models.QuizUser;
import com.example.quizepf_backend.services.QuizUserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("quiz_users")
@RestController
@RequiredArgsConstructor
public class QuizUserController {

    private final QuizUserServices quizUserService;

    @GetMapping("/user/{userId}")
    public List<QuizUser> getQuizUserByUserId(@PathVariable Long userId) { return quizUserService.getQuizUsersByUserId(userId);}

    @DeleteMapping("/{id}")
    public void deleteQuizUser(@PathVariable Long id) {
        quizUserService.deleteById(id);
    }

    @PostMapping("")
    public void addQuizUser(@RequestBody QuizUserDto userDto) {
        quizUserService.addQuizUser(userDto);
    }

    @PostMapping("/{id}")
    public void updateQuizUser(@RequestBody QuizUserDto quizUserDto, @PathVariable Long id) {
        quizUserService.updateQuizUser(quizUserDto, id);
    }

    @GetMapping("")
    public List<QuizUser> getQuizUsers() {
        return quizUserService.findAll();
    }

    @GetMapping("/{user_id}")
    public List<Ranking> getRanking(@PathVariable Long user_id) {
        return quizUserService.getRanking(user_id);
    }
}
