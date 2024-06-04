import { z } from 'zod';

// TODO Add category to item schema as a select Enum
export const itemSchema = z.object({
  name: z.string().min(2),
  desc: z.string().min(10),
  price: z.coerce.number().positive(),
  imageUrl: z.string().url(),
  quantity: z.coerce.number().positive().int(),
});

export type ItemSchemaType = z.infer<typeof itemSchema>;
