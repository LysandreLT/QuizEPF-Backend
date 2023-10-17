package com.example.quizepf_backend.DTO;

import com.example.quizepf_backend.models.Quiz;
import com.example.quizepf_backend.models.enums.QuestionType;
import lombok.Builder;
import lombok.Getter;

@Builder // MapStruct
@Getter
public class QuizQuestionDto {
    String question;
    Quiz quiz;
    QuestionType questionType;
}
