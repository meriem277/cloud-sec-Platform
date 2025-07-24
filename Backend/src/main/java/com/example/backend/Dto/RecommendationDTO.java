package com.example.backend.Dto;

import com.example.backend.Entites.Enums.riskLevel;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
public class RecommendationDTO {
    long idRecommendation;
    String message;
    riskLevel riskLevel;
}

