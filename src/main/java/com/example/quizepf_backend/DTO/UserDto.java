package com.example.quizepf_backend.DTO;

import lombok.Builder;
import lombok.Getter;

@Builder // MApStruct
@Getter
public class UserDto {
    private String firstName;
    private String lastName;
    private String password;

}
