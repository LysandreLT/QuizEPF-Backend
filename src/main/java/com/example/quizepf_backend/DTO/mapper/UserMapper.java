package com.example.quizepf_backend.DTO.mapper;

import com.example.quizepf_backend.DTO.UserDto;
import com.example.quizepf_backend.models.User;

import java.io.IOException;

public class UserMapper {
    public static User fromDto(UserDto dto, Long id) throws IOException {
        return new User.Builder()
                .id(id)
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .password(dto.getToken())
                .email(dto.getLogin())
                .build();
    }

    public static UserDto toDto (User user){
        return UserDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getEmail())
                .token(user.getPassword())
                .build();
    }
/*
    public static User signUpToUser(SignUpDto signUpDto){
        return new User.Builder()
                .firstName(signUpDto.firstName())
                .lastName(signUpDto.lastName())
                .email(signUpDto.login())
                .build();
    }*/
}
