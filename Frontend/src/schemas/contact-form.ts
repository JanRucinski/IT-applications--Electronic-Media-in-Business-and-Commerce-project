import { z } from 'zod';

export const contactFormSchema = z.object({
  firstName: z.string(),
  lastName: z.string(),
  email: z.string().email(),
  message: z.string().max(500),
});

export type ContactFormSchemaType = z.infer<typeof contactFormSchema>;
