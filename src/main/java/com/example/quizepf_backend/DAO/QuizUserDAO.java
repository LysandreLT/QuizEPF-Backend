package com.example.quizepf_backend.DAO;

import com.example.quizepf_backend.models.QuizUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizUserDAO extends JpaRepository<QuizUser, Long> {
}
