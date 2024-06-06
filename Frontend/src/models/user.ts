import { Role } from '@/types/roles';

export type User = {
  email: string;
  fullName: string;
  token: string;
  role: Role;
};
