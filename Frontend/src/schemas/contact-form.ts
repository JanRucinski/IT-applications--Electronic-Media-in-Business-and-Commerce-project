import { z } from 'zod';

export const contactFormSchema = z.object({
  firstName: z.string().min(2, 'Must be at least 2 characters'),
  lastName: z.string().min(2, 'Must be at least 2 characters'),
  email: z.string().email(),
  message: z.string().max(500).min(5, 'Must be at least 5 characters'),
});

export type ContactFormSchemaType = z.infer<typeof contactFormSchema>;
