package com.example.quizepf_backend.DTO.mapper;

import com.example.quizepf_backend.DTO.QuizDto;
import com.example.quizepf_backend.DTO.QuizQuestionDto;
import com.example.quizepf_backend.models.Quiz;
import com.example.quizepf_backend.models.QuizQuestion;

import java.io.IOException;

public class QuizQuestionMapper {
    public static QuizQuestion fromDto(QuizQuestionDto dto, Long id) throws IOException {
        return new QuizQuestion.Builder()
                .id(id)
                .quiz(dto.getQuiz())
                .questionType(dto.getQuestionType())
                .question(dto.getQuestion())
                .questionValue(dto.getQuestionValue())
                .build();
    }

    public static QuizQuestionDto toDto (QuizQuestion quizQuestion){
        return QuizQuestionDto.builder()
                .quiz(quizQuestion.getQuiz())
                .questionType(quizQuestion.getQuestionType())
                .question(quizQuestion.getQuestion())
                .build();
    }
}