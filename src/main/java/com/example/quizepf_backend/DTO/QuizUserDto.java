package com.example.quizepf_backend.DTO;

import com.example.quizepf_backend.models.Quiz;
import com.example.quizepf_backend.models.User;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;

@Builder // MapStruct
@Getter
public class QuizUserDto {
    private Quiz quiz;
    private User user;
    private int score;
}