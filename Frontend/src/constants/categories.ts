export type Category = {
  id: number;
  name: string;
};

export const bikesCategories: Category[] = [
  { id: 1, name: 'Mountain Bikes' },
  { id: 2, name: 'Road Bikes' },
  { id: 3, name: 'Hybrid Bikes' },
  { id: 4, name: 'Electric Bikes' },
  { id: 5, name: 'Folding Bikes' },
  { id: 6, name: 'Cruiser Bikes' },
  { id: 7, name: 'Kids Bikes' },
  { id: 8, name: 'Other' },
] as const;

export const partsCategories: Category[] = [
  { id: 21, name: 'Brakes' },
  { id: 22, name: 'Drivetrain' },
  { id: 23, name: 'Wheels' },
  { id: 24, name: 'Steering' },
  { id: 25, name: 'Seating' },
  { id: 26, name: 'Pedals' },
  { id: 27, name: 'Suspension' },
  { id: 28, name: 'Other' },
] as const;

export const rentalCategories: Category[] = [
  { id: 41, name: 'Mountain' },
  { id: 42, name: 'Road' },
  { id: 43, name: 'Hybrid' },
  { id: 44, name: 'Electric' },
  { id: 45, name: 'Folding' },
  { id: 46, name: 'Cruiser' },
  { id: 47, name: 'Kids' },
  { id: 48, name: 'Other' },
] as const;
