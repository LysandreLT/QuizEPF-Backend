package com.example.quizepf_backend.models;

import com.example.quizepf_backend.models.enums.QuestionType;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "quiz_questions")
@Getter
public class QuizQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "quiz_id")
    Quiz quiz;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "question_type")
    private QuestionType questionType;

    @Column(name = "question_value")
    private int questionValue;

    private QuizQuestion(QuizQuestion.Builder builder) {
        this.id = builder.id;
        this.question = builder.question;
        this.quiz = builder.quiz;
        this.questionType = builder.questionType;
        this.questionValue = builder.questionValue;

    }
    public QuizQuestion() {
    }

    public static class Builder {
        private Long id;
        private String question;
        private Quiz quiz;
        private QuestionType questionType;

        private int questionValue;


        public QuizQuestion.Builder id (Long id) {
            this.id = id;
            return this;
        }

        public QuizQuestion.Builder question(String question) {
            this.question = question;
            return this;
        }
        public QuizQuestion.Builder quiz(Quiz quiz) {
            this.quiz = quiz;
            return this;
        }
        public QuizQuestion.Builder questionType(QuestionType questionType) {
            this.questionType = questionType;
            return this;
        }

        public QuizQuestion.Builder questionValue(int questionValue){
            this.questionValue = questionValue;
            return  this;
        }
        public QuizQuestion build() {
            return new QuizQuestion(this);
        }
    }
}
