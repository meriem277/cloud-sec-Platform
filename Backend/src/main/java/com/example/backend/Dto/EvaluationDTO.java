package com.example.backend.Dto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EvaluationDTO {
    long idEvaluation;
    String title;
    String description;
    int rating;
    LocalDateTime dateCreated;
    long userId;

    List<QuestionDTO> questions;
    List<RecommendationDTO> recommendations;
}
