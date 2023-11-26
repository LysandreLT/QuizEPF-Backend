package com.example.quizepf_backend.services;

import com.example.quizepf_backend.DAO.QuizDAO;
import com.example.quizepf_backend.DTO.QuizDto;
import com.example.quizepf_backend.DTO.mapper.QuizMapper;
import com.example.quizepf_backend.models.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class QuizServices {

    private final QuizDAO quizDao;
    private final QuizUserServices quizUserServices;
    private final QuizQuestionServices quizQuestionServices;


    public List<Quiz> findAll() {
        Iterable<Quiz> it = quizDao.findAll();
        List <Quiz> quizzes = new ArrayList<>();
        it.forEach(quizzes::add);
        return quizzes ;
    }
    public Quiz getById(Long id) {
        return quizDao.findById(id).orElseThrow();
    }

    public List<Quiz> getQuizByUserId(Long userId){
        Iterable<Quiz> it = quizDao.findByUserId(userId);
        List<Quiz> quizzes = new ArrayList<>();
        it.forEach(quizzes::add);
        return quizzes;
    }

    @Transactional
    public void deleteQuizById(Long id) {

        quizQuestionServices.deleteQuestionsByQuizId(id);
        quizUserServices.deleteQuizUserByQuizId(id);
        quizDao.deleteById(id);
    }

    @Transactional
    public Quiz addQuiz(QuizDto quizUserDto) {
        Quiz quizUser;
        try {
            quizUser = QuizMapper.fromDto(quizUserDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with Quiz image", e);
        }

        return quizDao.save(quizUser);
    }

    @Transactional
    public void updateQuiz(QuizDto quizUserDto, Long id) {
        quizDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Quiz User doesn't exist"));
        Quiz quizUser;
        try {
            quizUser = QuizMapper.fromDto(quizUserDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with User image", e);
        }
        quizDao.save(quizUser);
    }

}
