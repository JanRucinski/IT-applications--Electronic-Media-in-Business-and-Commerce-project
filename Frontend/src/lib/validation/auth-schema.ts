import { z } from 'zod';

export const loginSchema = z.object({
  email: z.string().email(),
  password: z.string().min(6),
});

export type LoginSchemaType = z.infer<typeof loginSchema>;

export const signUpSchema = z.object({
  firstName: z.string().min(2),
  lastName: z.string().min(2),
  email: z.string().email(),
  phone: z.string().min(9),
  password: z.string().min(6),
});

export type SignUpSchemaType = z.infer<typeof signUpSchema>;
