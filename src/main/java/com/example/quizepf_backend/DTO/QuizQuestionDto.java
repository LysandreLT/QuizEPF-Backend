package com.example.quizepf_backend.DTO;

import com.example.quizepf_backend.models.Quiz;
import com.example.quizepf_backend.models.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder // MapStruct
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuizQuestionDto {
    String question;
    Quiz quiz;
    QuestionType questionType;
    int questionValue;
}
