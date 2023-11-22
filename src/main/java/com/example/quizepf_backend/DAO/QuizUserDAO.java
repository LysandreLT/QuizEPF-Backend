package com.example.quizepf_backend.DAO;

import com.example.quizepf_backend.models.QuizUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizUserDAO extends JpaRepository<QuizUser, Long> {

    List<QuizUser> findByUserId(Long userId);

    List<QuizUser> findByQuizId(Long userId);

    @Modifying
    @Query("DELETE FROM QuizUser qu WHERE qu.quiz.id = :quizId")
    void deleteByQuizId(@Param("quizId") Long quizId);
}
