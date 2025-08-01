import { Evaluation } from "./evaluation.model";

export enum QuestionType {
  MCQ = 'MCQ',        // Multiple Choice Question
  YES_NO = 'YES_NO',  // Oui/Non
  TEXT = 'TEXT'       // Réponse libre (si tu en as)
}

export interface Question {
  idQuestion: number;
  content: string;
  type: QuestionType;
  question: string;
  option1: string;
  option2: string;
  option3: string;
  userAnswer: string;
  evaluation?: Evaluation; // ou tu peux créer une interface Evaluation si elle est déjà prête
}
