package com.example.quizepf_backend.DTO;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder // MapStruct
@Getter
@Setter
public class Ranking {
    String quiz_name;
    int score;
    int ranking;
}
