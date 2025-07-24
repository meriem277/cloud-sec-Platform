package com.example.backend.Repositories;

import com.example.backend.Entites.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    // Additional query methods can be defined here if needed
}
