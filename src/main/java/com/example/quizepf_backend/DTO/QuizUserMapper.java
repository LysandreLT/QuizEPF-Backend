package com.example.quizepf_backend.DTO;

import com.example.quizepf_backend.models.QuizUser;
import com.example.quizepf_backend.models.User;

import java.io.IOException;

public class QuizUserMapper {
    public static QuizUser fromDto(QuizUserDto dto, Long id) throws IOException {
        return new QuizUser.Builder()
                .id(id)
                .quiz(dto.getQuiz())
                .user(dto.getUser())
                .score(dto.getScore())
                .build();
    }

    public static QuizUserDto toDto (QuizUser quizUser){
        return QuizUserDto.builder()
                .quiz(quizUser.getQuiz())
                .user(quizUser.getUser())
                .score(quizUser.getScore())
                .build();
    }
}
