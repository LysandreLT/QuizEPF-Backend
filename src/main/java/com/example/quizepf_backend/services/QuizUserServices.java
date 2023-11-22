package com.example.quizepf_backend.services;

import com.example.quizepf_backend.DAO.QuizUserDAO;
import com.example.quizepf_backend.DTO.*;
import com.example.quizepf_backend.DTO.mapper.QuizUserMapper;
import com.example.quizepf_backend.models.QuizUser;
import lombok.RequiredArgsConstructor;
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

    public List<QuizUser> getQuizUsersByUserId(Long userId){
        Iterable<QuizUser> it = quizUserDao.findByUserId(userId);
        List<QuizUser> quizUsers = new ArrayList<>();
        it.forEach(quizUsers::add);
        return quizUsers;
    }

    public List<Ranking> getRanking(Long userId){
        Iterable<QuizUser> it = quizUserDao.findByUserId(userId);
        List <Ranking> rankings = new ArrayList<>();
        it.forEach( (quizUser) -> {
            List<QuizUser> quizUsers = quizUserDao.findByQuizId(quizUser.getQuiz().getId());
            quizUsers.sort((qu1, qu2) -> qu2.getScore() - qu1.getScore());

            Ranking ranking = Ranking.builder()
                    .quiz_name(quizUser.getQuiz().getName())
                    .score(quizUser.getScore())
                    .ranking(quizUsers.indexOf(quizUser) + 1)
                    .build();
                    // get all user for a quiz (quizUsersByQuizId )
                    // sort by score
                    // get index
                    // map into ranking Dto

            rankings.add(ranking);

        });
        return rankings;
    }

    @Transactional
    public void deleteQuizUserById(Long id) {

        quizUserDao.deleteById(id);
    }

    @Transactional
    public void deleteQuizUserByQuizId(Long quizId) {

        quizUserDao.deleteByQuizId(quizId);
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
