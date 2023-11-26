package com.example.quizepf_backend.DTO.mapper;


import com.example.quizepf_backend.DTO.QuizDto;
import com.example.quizepf_backend.models.Quiz;

import java.io.IOException;

public class QuizMapper {
    public static Quiz fromDto(QuizDto dto, Long id) throws IOException {
        return new Quiz.Builder()
                .id(id)
                .name(dto.getName())
                .user(dto.getUser())
                .build();
    }

    public static QuizDto toDto (Quiz quizr){
        return QuizDto.builder()
                .name(quizr.getName())
                .user(quizr.getUser())
                .build();
    }
}
