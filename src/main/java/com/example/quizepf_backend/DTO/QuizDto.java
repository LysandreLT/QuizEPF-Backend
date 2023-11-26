package com.example.quizepf_backend.DTO;

import com.example.quizepf_backend.models.Quiz;
import com.example.quizepf_backend.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder // MapStruct
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private String name;
    private User user;
}
