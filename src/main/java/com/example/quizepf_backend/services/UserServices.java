package com.example.quizepf_backend.services;

import com.example.quizepf_backend.DAO.UserDAO;
import com.example.quizepf_backend.DTO.CredentialsDto;
import com.example.quizepf_backend.DTO.SignUpDto;
import com.example.quizepf_backend.DTO.UserDto;
import com.example.quizepf_backend.DTO.UserMapper;
import com.example.quizepf_backend.controler.UserController;
import com.example.quizepf_backend.exceptions.AppException;
import com.example.quizepf_backend.models.User;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServices {

    private final PasswordEncoder passwordEncoder;

    private final UserDAO userDao;
    public List<User> findAll() {
        Iterable<User> it = userDao.findAll();
        List <User> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userDao.findByEmail(credentialsDto.login())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.password()), user.getPassword())) {
            return UserMapper.toDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {

        System.out.println("first name: "+userDto.firstName() + ", last name: "+userDto.lastName() + ", email: "+userDto.login() + ", password: "+userDto.password());
        Optional<User> optionalUser = userDao.findByEmail(userDto.login());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = new User.Builder()
                .firstName(userDto.firstName())
                .lastName(userDto.lastName())
                .email(userDto.login())
                .password(passwordEncoder.encode(CharBuffer.wrap(userDto.password())))
                .build();

        /*System.out.println("first name: "+user.getFirstName() + ", last name: "+user.getLastName() + ", email: "+user.getEmail() + ", password: "+user.getPassword());*/
        User savedUser = userDao.save(user);

        return UserMapper.toDto(savedUser);
    }

    public UserDto findByLogin(String login) {
        User user = userDao.findByEmail(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return UserMapper.toDto(user);
    }

    public User getById(Long id) {
        return userDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    @Transactional
    public void addUser(UserDto studentDto) {
        User user;
        try {
            user = UserMapper.fromDto(studentDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with User image", e);
        }

        userDao.save(user);
    }

    @Transactional
    public void updateUser(UserDto userDto, Long id) {
        userDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User doesn't exist"));
        User user;
        try {
            user = UserMapper.fromDto(userDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with User image", e);
        }
        userDao.save(user);
    }

}
