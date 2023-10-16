package com.example.quizepf_backend.models;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "quiz_users")
@Getter
public class QuizUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    private int score;

    ////
    //@OneToOne(mappedBy = "quiz_users", cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn
    //private LeaderBoard leaderboard;

    private QuizUser(Builder builder) {
        this.id = builder.id;
        this.quiz = builder.quiz;
        this.user = builder.user;
        this.score = builder.score;

    }
    public QuizUser() {
    }

    public static class Builder {
        private Long id;
        private Quiz quiz;
        private User user;
        private int score;


        public Builder id (Long id) {
            this.id = id;
            return this;
        }

        public Builder quiz(Quiz quiz) {
            this.quiz = quiz;
            return this;
        }
        public Builder user(User user) {
            this.user = user;
            return this;
        }

        public Builder score(int score )
        {
            this.score = score;
            return  this;
        }
        public QuizUser build() {
            return new QuizUser(this);
        }
    }
}
