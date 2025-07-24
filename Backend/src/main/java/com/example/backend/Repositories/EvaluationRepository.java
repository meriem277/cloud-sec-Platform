package com.example.backend.Repositories;

import com.example.backend.Entites.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository  extends JpaRepository<Evaluation, Long> {
    // Additional query methods can be defined here if needed
}
