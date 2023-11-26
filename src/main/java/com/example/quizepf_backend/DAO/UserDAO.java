package com.example.quizepf_backend.DAO;

import com.example.quizepf_backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
    @Query("SELECT u from User u where u.email= :email")
    Optional<User> findByEmail(String email);
}
