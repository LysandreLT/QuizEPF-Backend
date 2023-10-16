package com.example.quizepf_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

public enum QuestionType {
    SINGLECHOICE,
    QCM,
    WRITENANSWER

}