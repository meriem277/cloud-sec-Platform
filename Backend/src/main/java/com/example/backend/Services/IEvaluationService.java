package com.example.backend.Services;

import com.example.backend.Dto.EvaluationDTO;

import java.util.List;

public interface IEvaluationService {
    EvaluationDTO createEvaluation(EvaluationDTO evaluationDTO);
    EvaluationDTO getEvaluationById(Long id);
    List<EvaluationDTO> getAllEvaluations();
    EvaluationDTO updateEvaluation(Long id, EvaluationDTO evaluationDTO);
    void deleteEvaluation(Long id);
}
