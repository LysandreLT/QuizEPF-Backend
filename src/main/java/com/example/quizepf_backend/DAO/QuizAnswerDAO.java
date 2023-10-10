package com.example.quizepf_backend.DAO;

import com.example.quizepf_backend.models.QuizAnswer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizAnswerDAO extends JpaRepository<QuizAnswer, Long> {
}
