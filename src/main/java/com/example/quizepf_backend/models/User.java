package com.example.quizepf_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "users")
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", length=50, nullable=false, unique=false)
    private String firstName;
    @Column(name = "last_name", length=50, nullable=false, unique=false)
    private String lastName;
    private String password;
    private String email;
    //@Column(name = "mobile_phone")
    //private int mobilePhone;


    // for join many-to-many relationship with quiz
    //@OneToMany
    //Set<QuizUser> quizUser;

    private User(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.password = builder.password;
        this.email = builder.email;

    }
    public User() {
    }

    public static class Builder {
        private Long id;
        private String firstName;
        private String lastName;
        private String password;
        private String email;


        public Builder id (Long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email){
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
