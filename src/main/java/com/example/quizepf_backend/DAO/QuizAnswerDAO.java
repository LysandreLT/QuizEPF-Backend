package com.example.quizepf_backend.DAO;

import com.example.quizepf_backend.models.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizAnswerDAO extends JpaRepository<QuizAnswer, Long> {

    @Query("SELECT qa FROM QuizAnswer qa JOIN qa.quizQuestion qq WHERE qq.quiz.id=:quizId")
    List<QuizAnswer> findQuizAnswersByQuizId(Long quizId);
}
