package com.example.quizepf_backend.services;

import com.example.quizepf_backend.DAO.UserDAO;
import com.example.quizepf_backend.DTO.UserDto;
import com.example.quizepf_backend.DTO.UserMapper;
import com.example.quizepf_backend.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServices {

    private final UserDAO userDao;
    public List<User> findAll() {
        Iterable<User> it = userDao.findAll();
        List <User> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
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
