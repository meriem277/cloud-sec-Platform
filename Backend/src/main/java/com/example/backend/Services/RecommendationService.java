package com.example.backend.Services;

import com.example.backend.Dto.RecommendationDTO;
import com.example.backend.Entites.Evaluation;
import com.example.backend.Entites.Recommendation;
import com.example.backend.Repositories.EvaluationRepository;
import com.example.backend.Repositories.RecommendationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class RecommendationService implements IRecommendationService {

    private final RecommendationRepository recommendationRepository;
    private final EvaluationRepository evaluationRepository;

    @Override
    public RecommendationDTO createRecommendation(RecommendationDTO dto, Long evaluationId) {
        Evaluation eval = evaluationRepository.findById(evaluationId).orElse(null);
        if (eval == null) return null;

        Recommendation rec = Recommendation.builder()
                .message(dto.getMessage())
                .RiskLevel(dto.getRiskLevel())
                .evaluation(eval)
                .build();
        Recommendation saved = recommendationRepository.save(rec);

        return mapToDTO(saved);
    }

    @Override
    public RecommendationDTO getRecommendationById(Long id) {
        return recommendationRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public List<RecommendationDTO> getAllRecommendations() {
        return recommendationRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RecommendationDTO updateRecommendation(Long id, RecommendationDTO dto) {
        Optional<Recommendation> optional = recommendationRepository.findById(id);
        if (optional.isEmpty()) return null;
        Recommendation rec = optional.get();

        rec.setMessage(dto.getMessage());
        rec.setRiskLevel(dto.getRiskLevel());

        return mapToDTO(recommendationRepository.save(rec));
    }

    @Override
    public void deleteRecommendation(Long id) {
        recommendationRepository.deleteById(id);
    }

    private RecommendationDTO mapToDTO(Recommendation rec) {
        return RecommendationDTO.builder()
                .idRecommendation(rec.getIdRecommendation())
                .message(rec.getMessage())
                .riskLevel(rec.getRiskLevel())
                .build();
    }

}
