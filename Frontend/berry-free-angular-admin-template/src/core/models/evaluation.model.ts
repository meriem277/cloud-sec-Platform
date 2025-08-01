import { User } from './user.model';
import { Question } from './question.model';
import { Recommendation } from './recommendation.model';

export interface Evaluation {
  idEvaluation: number;
  title: string;
  description: string;
  rating: number;
  dateCreated: Date; // ou string si c’est format ISO
  user?: User;
  questions?: Question[];
  recommendations?: Recommendation[];
}
