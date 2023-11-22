package com.example.quizepf_backend.DAO;

import com.example.quizepf_backend.models.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizAnswerDAO extends JpaRepository<QuizAnswer, Long> {

    @Modifying
    @Query("DELETE FROM QuizAnswer ans WHERE ans.quizQuestion.id = :questionId")
    List<Long> deleteByQuizId(@Param("questionId") Long questionId);

    @Query("SELECT qa FROM QuizAnswer qa JOIN qa.quizQuestion qq WHERE qq.quiz.id=:quizId")
    List<QuizAnswer> findQuizAnswersByQuizId(Long quizId);


}
