import { z } from 'zod';

export const itemSchema = z.object({
  name: z.string().min(2),
  desc: z.string().min(10),
  price: z.coerce.number().positive(),
  imageUrl: z.string().url(),
  quantity: z.coerce.number().positive().int(),
  categoryId: z.coerce.number().int(),
});

export type ItemSchemaType = z.infer<typeof itemSchema>;
