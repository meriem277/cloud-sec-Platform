package com.example.backend.Entites;

import com.example.backend.Entites.Enums.riskLevel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level= AccessLevel.PRIVATE)
@Entity
@Data
public class Recommendation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long idRecommendation;
    private String message ;
    @Enumerated(EnumType.STRING)
    private riskLevel RiskLevel;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "evaluation_id")
    Evaluation evaluation;

}
