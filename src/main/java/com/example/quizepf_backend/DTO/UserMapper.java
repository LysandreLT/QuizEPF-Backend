package com.example.quizepf_backend.DTO;

import com.example.quizepf_backend.models.User;

import java.io.IOException;

public class UserMapper {
    public static User fromDto(UserDto dto, Long id) throws IOException {
        return new User.Builder()
                .id(id)
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .password(dto.getPassword())
                .build();
    }

    public static UserDto toDto (User student){
        return UserDto.builder()
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .password(student.getPassword())
                .build();
    }
}
