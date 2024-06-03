import { z } from 'zod';

export const itemSchema = z.object({
  name: z.string().min(2),
  description: z.string().min(10),
  price: z.number().positive(),
  maxQuantity: z.number().positive(),
});

export type ItemSchemaType = z.infer<typeof itemSchema>;
