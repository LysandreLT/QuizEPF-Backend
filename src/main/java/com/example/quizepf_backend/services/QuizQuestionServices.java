package com.example.quizepf_backend.services;


import com.example.quizepf_backend.DAO.QuizQuestionDAO;
import com.example.quizepf_backend.DTO.QuizQuestionDto;
import com.example.quizepf_backend.DTO.mapper.QuizQuestionMapper;
import com.example.quizepf_backend.models.QuizQuestion;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class QuizQuestionServices {
    private final QuizQuestionDAO quizQuestionDao;
    private final QuizAnswerServices quizAnswerServices;
    public List<QuizQuestion> findAll() {
        Iterable<QuizQuestion> it = quizQuestionDao.findAll();
        List <QuizQuestion> quizzes = new ArrayList<>();
        it.forEach(quizzes::add);
        return quizzes ;
    }
    public QuizQuestion getById(Long id) {
        return quizQuestionDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        quizQuestionDao.deleteById(id);
    }

    @Transactional
    public void deleteQuestionsByQuizId(Long quizId) {

        List<Long> deletedQuestionsId = quizQuestionDao.findByQuizId(quizId);
        for (Long deletedQuestionId : deletedQuestionsId) {
            quizAnswerServices.deleteQuizAnswerByQuestionId(deletedQuestionId);
        }
    }

    @Transactional
    public QuizQuestion addQuizQuestion(QuizQuestionDto quizUserDto) {
        QuizQuestion quizQuestion;
        try {
            quizQuestion = QuizQuestionMapper.fromDto(quizUserDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with quiz answer image", e);
        }

        return quizQuestionDao.save(quizQuestion);
    }

    @Transactional
    public void updateQuizQuestion(QuizQuestionDto quizUserDto, Long id) {
        quizQuestionDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("quiz answer doesn't exist"));
        QuizQuestion quizQuestion;
        try {
            quizQuestion = QuizQuestionMapper.fromDto(quizUserDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with quiz answer image", e);
        }
        quizQuestionDao.save(quizQuestion);
    }
}

