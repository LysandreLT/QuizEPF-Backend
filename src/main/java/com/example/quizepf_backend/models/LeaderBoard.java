package com.example.quizepf_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "leaderboard")
@NoArgsConstructor
@Getter
public class LeaderBoard {
    @Id
    @Column(name = "quiz_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
