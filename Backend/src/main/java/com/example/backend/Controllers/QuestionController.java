package com.example.backend.Controllers;
import com.example.backend.Dto.QuestionDTO;
import com.example.backend.Services.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/question")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @PostMapping
    public QuestionDTO add(@RequestBody QuestionDTO dto) {
        return questionService.addQuestion(dto);
    }

    @PutMapping("/{id}")
    public QuestionDTO update(@PathVariable Long id, @RequestBody QuestionDTO dto) {
        return questionService.updateQuestion(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }

    @GetMapping("/{id}")
    public QuestionDTO getById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping
    public List<QuestionDTO> getAll() {
        return questionService.getAllQuestions();
    }
}
