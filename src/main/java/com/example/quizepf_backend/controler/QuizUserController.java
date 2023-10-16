package com.example.quizepf_backend.controler;

import com.example.quizepf_backend.DTO.QuizUserDto;
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

    @GetMapping("/{id}")
    public QuizUser getQuizUserById(@PathVariable Long id) {
        return quizUserService.getById(id);
    }
    @GetMapping("/user/{id}")
    public List<QuizUser> getQuizUserByUserId(@PathVariable Long userId) { return quizUserService.getByUserId(userId);}
    @GetMapping("/quiz/{id}")
    public List<QuizUser> getQuizUserByQuizId(@PathVariable Long quizId) { return quizUserService.getByQuizId(quizId);}

    @GetMapping("/quiz_user/{id}")
    public QuizUser getQuizUserByUserIdAndQuizId(@PathVariable Long quizId,@PathVariable Long userId) { return quizUserService.getByUserIdAndQuizId(quizId, userId);}
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
}
