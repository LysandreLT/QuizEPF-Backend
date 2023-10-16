package com.example.quizepf_backend.DTO;

import com.example.quizepf_backend.models.QuizQuestion;
import lombok.Builder;
import lombok.Getter;

@Builder // MapStruct
@Getter
public class QuizAnswerDto {
    QuizQuestion quizQuestion;
    boolean isTrue;
    String answer;
}
