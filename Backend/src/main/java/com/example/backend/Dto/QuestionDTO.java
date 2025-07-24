package com.example.backend.Dto;

import com.example.backend.Entites.Enums.QuestionType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuestionDTO {
    long idQuestion;
    String content;
    QuestionType type;
    String question;
    String option1;
    String option2;
    String option3;
    String userAnswer;
}
