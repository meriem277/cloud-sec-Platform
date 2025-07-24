package com.example.backend.Services;

import com.example.backend.Dto.RecommendationDTO;

import java.util.List;

public interface IRecommendationService {
    RecommendationDTO createRecommendation(RecommendationDTO dto, Long evaluationId);
    RecommendationDTO getRecommendationById(Long id);
    List<RecommendationDTO> getAllRecommendations();
    RecommendationDTO updateRecommendation(Long id, RecommendationDTO dto);
    void deleteRecommendation(Long id);
}
