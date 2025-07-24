package com.example.backend.Services;

import com.example.backend.Dto.EvaluationDTO;
import com.example.backend.Dto.QuestionDTO;
import com.example.backend.Dto.RecommendationDTO;
import com.example.backend.Entites.Evaluation;
import com.example.backend.Entites.Question;
import com.example.backend.Entites.Recommendation;
import com.example.backend.Entites.User;
import com.example.backend.Repositories.EvaluationRepository;
import com.example.backend.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EvaluationService {

    @Autowired
    EvaluationRepository evaluationRepository;

    @Autowired
    UserRepository userRepository;

    // ✅ CREATE
    public EvaluationDTO createEvaluation(EvaluationDTO dto) {
        Evaluation eval = new Evaluation();
        eval.setTitle(dto.getTitle());
        eval.setDescription(dto.getDescription());
        eval.setRating(dto.getRating());
        eval.setDateCreated(LocalDateTime.now());

        if (dto.getUserId() != 0) {
            Optional<User> user = userRepository.findById(dto.getUserId());
            user.ifPresent(eval::setUser);
        }

        if (dto.getQuestions() != null) {
            List<Question> questions = dto.getQuestions().stream().map(q -> {
                Question question = new Question();
                question.setContent(q.getContent());
                question.setType(q.getType());
                question.setQuestion(q.getQuestion());
                question.setOption1(q.getOption1());
                question.setOption2(q.getOption2());
                question.setOption3(q.getOption3());
                question.setUserAnswer(q.getUserAnswer());
                question.setEvaluation(eval); // important !
                return question;
            }).collect(Collectors.toList());
            eval.setQuestions(questions);
        }

        if (dto.getRecommendations() != null) {
            List<Recommendation> recs = dto.getRecommendations().stream().map(r -> {
                Recommendation recommendation = new Recommendation();
                recommendation.setMessage(r.getMessage());
                recommendation.setRiskLevel(r.getRiskLevel());
                recommendation.setEvaluation(eval);
                return recommendation;
            }).collect(Collectors.toList());
            eval.setRecommendations(recs);
        }

        evaluationRepository.save(eval);
        dto.setIdEvaluation(eval.getIdEvaluation());
        dto.setDateCreated(eval.getDateCreated());
        return dto;
    }

    // ✅ READ BY ID
    public Optional<EvaluationDTO> getEvaluationById(Long id) {
        return evaluationRepository.findById(id).map(eval -> {
            EvaluationDTO dto = new EvaluationDTO();
            dto.setIdEvaluation(eval.getIdEvaluation());
            dto.setTitle(eval.getTitle());
            dto.setDescription(eval.getDescription());
            dto.setRating(eval.getRating());
            dto.setDateCreated(eval.getDateCreated());

            if (eval.getUser() != null)
                dto.setUserId(eval.getUser().getIdUser());

            dto.setQuestions(eval.getQuestions().stream().map(q -> QuestionDTO.builder()
                    .idQuestion(q.getIdQuestion())
                    .content(q.getContent())
                    .type(q.getType())
                    .question(q.getQuestion())
                    .option1(q.getOption1())
                    .option2(q.getOption2())
                    .option3(q.getOption3())
                    .userAnswer(q.getUserAnswer())
                    .build()).collect(Collectors.toList()));

            dto.setRecommendations(eval.getRecommendations().stream().map(r -> RecommendationDTO.builder()
                    .idRecommendation(r.getIdRecommendation())
                    .message(r.getMessage())
                    .riskLevel(r.getRiskLevel())
                    .build()).collect(Collectors.toList()));

            return dto;
        });
    }

    // ✅ READ ALL
    public List<EvaluationDTO> getAllEvaluations() {
        return evaluationRepository.findAll().stream().map(eval -> {
            EvaluationDTO dto = new EvaluationDTO();
            dto.setIdEvaluation(eval.getIdEvaluation());
            dto.setTitle(eval.getTitle());
            dto.setDescription(eval.getDescription());
            dto.setRating(eval.getRating());
            dto.setDateCreated(eval.getDateCreated());

            if (eval.getUser() != null)
                dto.setUserId(eval.getUser().getIdUser());

            dto.setQuestions(eval.getQuestions().stream().map(q -> QuestionDTO.builder()
                    .idQuestion(q.getIdQuestion())
                    .content(q.getContent())
                    .type(q.getType())
                    .question(q.getQuestion())
                    .option1(q.getOption1())
                    .option2(q.getOption2())
                    .option3(q.getOption3())
                    .userAnswer(q.getUserAnswer())
                    .build()).collect(Collectors.toList()));

            dto.setRecommendations(eval.getRecommendations().stream().map(r -> RecommendationDTO.builder()
                    .idRecommendation(r.getIdRecommendation())
                    .message(r.getMessage())
                    .riskLevel(r.getRiskLevel())
                    .build()).collect(Collectors.toList()));

            return dto;
        }).collect(Collectors.toList());
    }

    // ✅ UPDATE
    @Transactional
    public EvaluationDTO updateEvaluation(Long id, EvaluationDTO dto) {
        Optional<Evaluation> optional = evaluationRepository.findById(id);
        if (optional.isEmpty()) return null;

        Evaluation eval = optional.get();
        eval.setTitle(dto.getTitle());
        eval.setDescription(dto.getDescription());
        eval.setRating(dto.getRating());

        // Optional: Update questions & recommendations if needed (clean old + insert new)
        // For now, we keep them as is. You can expand this logic later.

        evaluationRepository.save(eval);
        return dto;
    }

    // ✅ DELETE
    public void deleteEvaluation(Long id) {
        evaluationRepository.deleteById(id);
    }
}
