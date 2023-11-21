package com.example.quizepf_backend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "quizzes")
@Getter
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "created_by")
    private User user;

    // for join many-to-many relationship with user
    //@OneToMany
    //Set<QuizUser> quizUser;

    private Quiz(Builder builder)
    {
        this.id = builder.id;
        this.name = builder.name;
        this.user = builder.user;
    }

    public Quiz(){

    }

    public static class Builder {
        private Long id;
        private String name;
        private User user;


        public Builder id (Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder user(User user) {
            this.user = user;
            return this;
        }
        public Quiz build() {
            return new Quiz(this);
        }
    }
}
