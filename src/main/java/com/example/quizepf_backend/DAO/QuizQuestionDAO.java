package com.example.quizepf_backend.DAO;

import com.example.quizepf_backend.models.QuizQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizQuestionDAO extends JpaRepository<QuizQuestion, Long> {
}
