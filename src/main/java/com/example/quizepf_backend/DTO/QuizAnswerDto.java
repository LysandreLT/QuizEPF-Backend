package com.example.quizepf_backend.DTO;

import com.example.quizepf_backend.models.QuizQuestion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder // MapStruct
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuizAnswerDto {
    QuizQuestion quizQuestion;
    Boolean isTrue;
    String answer;
}
