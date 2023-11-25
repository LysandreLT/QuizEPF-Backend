package com.example.quizepf_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quiz_answers")
@Getter
public class QuizAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "quiz_question_id")
    QuizQuestion quizQuestion;

    @Column(name = "is_true")
    private Boolean isTrue;

    private String answer;

    private QuizAnswer(Builder builder)
    {
        this.id = builder.id;
        this.quizQuestion = builder.quizQuestion;
        this.isTrue = builder.isTrue;
        this.answer = builder.answer;
    }
    public QuizAnswer() {

    }

    public boolean isTrue() {
        return isTrue;
    }

    public static class Builder {
        private Long id;
        QuizQuestion quizQuestion;
        private boolean isTrue;
        private String answer;

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder quizQuestion(QuizQuestion quizQuestion) {
            this.quizQuestion = quizQuestion;
            return this;
        }

        public Builder isTrue(boolean isTrue){
            this.isTrue = isTrue;
            return this;
        }

        public Builder answer(String answer) {
            this.answer = answer;
            return  this;
        }

        public QuizAnswer build(){
            return new QuizAnswer(this);
        }
    }
}
