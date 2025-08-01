import { Evaluation } from './evaluation.model';

export enum RiskLevel {
  LOW = 'LOW',
  MEDIUM = 'MEDIUM',
  HIGH = 'HIGH'
}

export interface Recommendation {
  idRecommendation: number;
  message: string;
  riskLevel: RiskLevel;
  evaluation?: Evaluation;
}
