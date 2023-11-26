package com.example.quizepf_backend.controler;

import com.example.quizepf_backend.DTO.CredentialsDto;
import com.example.quizepf_backend.DTO.SignUpDto;
import com.example.quizepf_backend.DTO.UserDto;
import com.example.quizepf_backend.configuration.UserAuthentificationProvider;
import com.example.quizepf_backend.models.User;
import com.example.quizepf_backend.services.UserServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Arrays;

@RequiredArgsConstructor
@RestController
public class AuthController {

    private final UserServices userService;
    private final UserAuthentificationProvider userAuthenticationProvider;

    @PostMapping("/login")
    public ResponseEntity<UserDto> login(@RequestBody @Valid CredentialsDto credentialsDto) {
        UserDto userDto = userService.login(credentialsDto);
        userDto.setPassword(userAuthenticationProvider.createToken(userDto));
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody @Valid SignUpDto user) {

        UserDto createdUser = userService.register(user);
        createdUser.setPassword(userAuthenticationProvider.createToken(createdUser));
        return ResponseEntity.created(URI.create("/users/" + createdUser.getId())).body(createdUser);
    }

    @GetMapping("/id")
    public ResponseEntity<Long> getUserId(){
        return ResponseEntity.ok(userService.getUserId());
    }
}