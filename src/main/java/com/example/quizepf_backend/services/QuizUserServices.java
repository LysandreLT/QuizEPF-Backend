package com.example.quizepf_backend.services;

import com.example.quizepf_backend.DAO.QuizUserDAO;
import com.example.quizepf_backend.DTO.*;
import com.example.quizepf_backend.exceptions.AppException;
import com.example.quizepf_backend.models.QuizUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class QuizUserServices {

    private final QuizUserDAO quizUserDao;
    public List<QuizUser> findAll() {
        Iterable<QuizUser> it = quizUserDao.findAll();
        List <QuizUser> quizUsers = new ArrayList<>();
        it.forEach(quizUsers::add);
        return quizUsers ;
    }
    public QuizUser getById(Long id) {
        return quizUserDao.findById(id).orElseThrow();
    }

    public List<QuizUser> getByUserId(Long id) {
        Iterable<QuizUser> it = quizUserDao.findByUserId(id);
        List <QuizUser> quizUsers = new ArrayList<>();
        it.forEach(quizUsers::add);
        return quizUsers ;
        //return quizUserDao.findByUserId(id).orElseThrow(() -> new AppException("Unknown quizUser", HttpStatus.NOT_FOUND));
    }
    public List<QuizUser> getByQuizId(Long id) {
        Iterable<QuizUser> it = quizUserDao.findByQuizId(id);
        List <QuizUser> quizUsers = new ArrayList<>();
        it.forEach(quizUsers::add);
        return quizUsers ;
    }
    public QuizUser getByUserIdAndQuizId(Long quizId, Long userId) {
        return quizUserDao.findByQuizIdAndUserId(quizId, userId); //.orElseThrow(() -> new AppException("Unknown quiz for this user", HttpStatus.NOT_FOUND))
    }

    @Transactional
    public void deleteById(Long id) {
        quizUserDao.deleteById(id);
    }

    @Transactional
    public void addQuizUser(QuizUserDto quizUserDto) {
        QuizUser quizUser;
        try {
            quizUser = QuizUserMapper.fromDto(quizUserDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with QuizUser image", e);
        }

        quizUserDao.save(quizUser);
    }

    @Transactional
    public void updateQuizUser(QuizUserDto quizUserDto, Long id) {
        quizUserDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Quiz User doesn't exist"));
        QuizUser quizUser;
        try {
            quizUser = QuizUserMapper.fromDto(quizUserDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with User image", e);
        }
        quizUserDao.save(quizUser);
    }

}
