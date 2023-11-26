package com.example.quizepf_backend.DAO;

import com.example.quizepf_backend.models.Quiz;
import com.example.quizepf_backend.models.QuizUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizDAO extends JpaRepository<Quiz, Long> {

    List<Quiz> findByUserId(Long userId);
}
