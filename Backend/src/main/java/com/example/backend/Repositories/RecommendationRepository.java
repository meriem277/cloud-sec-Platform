package com.example.backend.Repositories;

import com.example.backend.Entites.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    // Additional query methods can be defined here if needed
}
