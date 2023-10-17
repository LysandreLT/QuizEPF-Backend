package com.example.quizepf_backend.services;

import com.example.quizepf_backend.DAO.QuizAnswerDAO;
import com.example.quizepf_backend.DTO.QuizAnswerDto;
import com.example.quizepf_backend.DTO.mapper.QuizAnswerMapper;
import com.example.quizepf_backend.models.QuizAnswer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
@Service
@RequiredArgsConstructor
public class QuizAnswerServices {
    private final QuizAnswerDAO quizAnswerDao;
    public List<QuizAnswer> findAll() {
        Iterable<QuizAnswer> it = quizAnswerDao.findAll();
        List <QuizAnswer> quizzes = new ArrayList<>();
        it.forEach(quizzes::add);
        return quizzes ;
    }
    public QuizAnswer getById(Long id) {
        return quizAnswerDao.findById(id).orElseThrow();
    }

    @Transactional
    public void deleteById(Long id) {
        quizAnswerDao.deleteById(id);
    }

    @Transactional
    public void addQuizAnswer(QuizAnswerDto quizUserDto) {
        QuizAnswer quizAnswer;
        try {
            quizAnswer = QuizAnswerMapper.fromDto(quizUserDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with quiz answer image", e);
        }

        quizAnswerDao.save(quizAnswer);
    }

    @Transactional
    public void updateQuizAnswer(QuizAnswerDto quizUserDto, Long id) {
        quizAnswerDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("quiz answer doesn't exist"));
        QuizAnswer quizAnswer;
        try {
            quizAnswer = QuizAnswerMapper.fromDto(quizUserDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with quiz answer image", e);
        }
        quizAnswerDao.save(quizAnswer);
    }
}
