export type Item = {
  id: string;
  name: string;
  description: string;
  price: number;
  image: string;
  maxQuantity?: number;
};

type DetailedItem = Item & {
  brand: string;
  model: string;
  weight: number;
  specifications: { [key: string]: string | number }[];
};

export type DetailedBikeItem = DetailedItem & {
  bikeType: string;
  frameMaterial: string;
  brakeType: string;
  wheelSize: number;
};

export type DetailedPartItem = DetailedItem & {
  partType: string;
  material: string;
};
