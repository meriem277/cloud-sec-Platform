export enum RoleType {
  ADMIN = 'ADMIN',
  USER = 'USER',

}

export interface User {
  idUser: number;
  username: string;
  email: string;
  password: string;
  image: string;
  phone: string;
  address: string;
  role: RoleType;
  verificationToken: string;
  enabled: boolean;
  // Tu peux rajouter une interface Evaluation si nécessaire
 // evaluations?: unknown[];
}
