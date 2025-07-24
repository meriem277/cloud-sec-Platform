package com.example.backend.Services;

import com.example.backend.Dto.QuestionDTO;
import com.example.backend.Entites.Question;
import com.example.backend.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService implements IQusetionService {
    @Autowired
     QuestionRepository questionRepository;


    private QuestionDTO convertToDTO(Question question) {
        return QuestionDTO.builder()
                .idQuestion(question.getIdQuestion())
                .content(question.getContent())
                .type(question.getType())
                .question(question.getQuestion())
                .option1(question.getOption1())
                .option2(question.getOption2())
                .option3(question.getOption3())
                .userAnswer(question.getUserAnswer())
                .build();
    }

    private Question convertToEntity(QuestionDTO dto) {
        return Question.builder()
                .idQuestion(dto.getIdQuestion())
                .content(dto.getContent())
                .type(dto.getType())
                .question(dto.getQuestion())
                .option1(dto.getOption1())
                .option2(dto.getOption2())
                .option3(dto.getOption3())
                .userAnswer(dto.getUserAnswer())
                .build();
    }

    @Override
    public QuestionDTO addQuestion(QuestionDTO questionDTO) {
        Question saved = questionRepository.save(convertToEntity(questionDTO));
        return convertToDTO(saved);
    }

    @Override
    public QuestionDTO updateQuestion(Long id, QuestionDTO questionDTO) {
        Question existing = questionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Question not found"));
        existing.setContent(questionDTO.getContent());
        existing.setType(questionDTO.getType());
        existing.setQuestion(questionDTO.getQuestion());
        existing.setOption1(questionDTO.getOption1());
        existing.setOption2(questionDTO.getOption2());
        existing.setOption3(questionDTO.getOption3());
        existing.setUserAnswer(questionDTO.getUserAnswer());
        return convertToDTO(questionRepository.save(existing));
    }

    @Override
    public void deleteQuestion(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public QuestionDTO getQuestionById(Long id) {
        return questionRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Question not found"));
    }

    @Override
    public List<QuestionDTO> getAllQuestions() {
        return questionRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
