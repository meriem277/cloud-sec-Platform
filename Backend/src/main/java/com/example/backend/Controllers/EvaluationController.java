package com.example.backend.Controllers;
import com.example.backend.Dto.EvaluationDTO;
import com.example.backend.Services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/evaluations")
@CrossOrigin(origins = "*") //
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    // ✅ CREATE
    @PostMapping
    public EvaluationDTO createEvaluation(@RequestBody EvaluationDTO evaluationDTO) {
        return evaluationService.createEvaluation(evaluationDTO);
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public Optional<EvaluationDTO> getEvaluationById(@PathVariable Long id) {
        return evaluationService.getEvaluationById(id);
    }

    // ✅ GET ALL
    @GetMapping
    public List<EvaluationDTO> getAllEvaluations() {
        return evaluationService.getAllEvaluations();
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public EvaluationDTO updateEvaluation(@PathVariable Long id, @RequestBody EvaluationDTO evaluationDTO) {
        return evaluationService.updateEvaluation(id, evaluationDTO);
    }

    // ✅ DELETE
    @DeleteMapping("/{id}")
    public void deleteEvaluation(@PathVariable Long id) {
        evaluationService.deleteEvaluation(id);
    }
}
