package com.example.backend.Controllers;

import com.example.backend.Dto.RecommendationDTO;
import com.example.backend.Services.IRecommendationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recommendations")
@RequiredArgsConstructor
public class RecommendationController {
    private final IRecommendationService recommendationService;

    @PostMapping("/create/{evaluationId}")
    public ResponseEntity<RecommendationDTO> create(@RequestBody RecommendationDTO dto, @PathVariable Long evaluationId) {
        return ResponseEntity.ok(recommendationService.createRecommendation(dto, evaluationId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecommendationDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(recommendationService.getRecommendationById(id));
    }

    @GetMapping
    public ResponseEntity<List<RecommendationDTO>> getAll() {
        return ResponseEntity.ok(recommendationService.getAllRecommendations());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecommendationDTO> update(@PathVariable Long id, @RequestBody RecommendationDTO dto) {
        return ResponseEntity.ok(recommendationService.updateRecommendation(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        recommendationService.deleteRecommendation(id);
        return ResponseEntity.noContent().build();
    }
}
