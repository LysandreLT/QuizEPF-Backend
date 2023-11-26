package com.example.quizepf_backend.DTO.mapper;

import com.example.quizepf_backend.DTO.QuizAnswerDto;
import com.example.quizepf_backend.DTO.QuizDto;
import com.example.quizepf_backend.models.Quiz;
import com.example.quizepf_backend.models.QuizAnswer;

import java.io.IOException;

public class QuizAnswerMapper {
    public static QuizAnswer fromDto(QuizAnswerDto dto, Long id) throws IOException {
        return new QuizAnswer.Builder()
                .id(id)
                .quizQuestion(dto.getQuizQuestion())
                .isTrue(dto.getIsTrue())
                .answer(dto.getAnswer())
                .build();
    }

    public static QuizAnswerDto toDto (QuizAnswer quizAnswer){
        return QuizAnswerDto.builder()
                .quizQuestion(quizAnswer.getQuizQuestion())
                .isTrue(quizAnswer.isTrue())
                .answer(quizAnswer.getAnswer())
                .build();
    }
}