package com.example.backend.Services;

import com.example.backend.Dto.QuestionDTO;

import java.util.List;

public interface IQusetionService {
    QuestionDTO addQuestion(QuestionDTO questionDTO);
    QuestionDTO updateQuestion(Long id, QuestionDTO questionDTO);
    void deleteQuestion(Long id);
    QuestionDTO getQuestionById(Long id);
    List<QuestionDTO> getAllQuestions();
}
