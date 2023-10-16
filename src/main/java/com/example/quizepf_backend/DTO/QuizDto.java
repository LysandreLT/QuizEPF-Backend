package com.example.quizepf_backend.DTO;

import com.example.quizepf_backend.models.Quiz;
import com.example.quizepf_backend.models.User;
import lombok.Builder;
import lombok.Getter;

@Builder // MapStruct
@Getter
public class QuizDto {
    private String name;
    private User user;
}
