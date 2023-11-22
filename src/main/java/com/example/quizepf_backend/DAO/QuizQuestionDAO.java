package com.example.quizepf_backend.DAO;

import com.example.quizepf_backend.models.QuizQuestion;
import com.example.quizepf_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizQuestionDAO extends JpaRepository<QuizQuestion, Long> {

    @Query("SELECT qu.id from QuizQuestion qu where qu.quiz.id= :quizId")
    List<Long> findByQuizId(Long quizId);
    @Modifying
    @Query("DELETE FROM QuizQuestion qu WHERE qu.quiz.id = :quizId")
    void deleteByQuizId(@Param("quizId") Long quizId);
}
