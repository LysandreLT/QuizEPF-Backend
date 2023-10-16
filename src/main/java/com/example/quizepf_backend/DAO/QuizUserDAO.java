package com.example.quizepf_backend.DAO;

import com.example.quizepf_backend.models.QuizUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuizUserDAO extends JpaRepository<QuizUser, Long> {

    @Query("SELECT qu FROM QuizUser qu JOIN qu.user u WHERE u.id= :userId")
    List<QuizUser> findByUserId(Long userId);
    @Query("SELECT qu FROM QuizUser qu JOIN qu.quiz q WHERE q.id= :id")
    List<QuizUser> findByQuizId(Long id);

    @Query("SELECT qu FROM QuizUser qu JOIN qu.user u JOIN qu.quiz q WHERE u.id= :userId AND q.id= :quizId")
    QuizUser findByQuizIdAndUserId(Long quizId, Long userId);
}
