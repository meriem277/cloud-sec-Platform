package com.example.backend.Entites;

import com.example.backend.Entites.Enums.QuestionType;
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
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idQuestion;

    private String content;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    private String question;

    private String option1;
    private String option2;
    private String option3;

    private String userAnswer;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "evaluation_id")
    private Evaluation evaluation;
}
