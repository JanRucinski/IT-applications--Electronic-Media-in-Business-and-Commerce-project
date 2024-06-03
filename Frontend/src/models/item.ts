export type Item = {
  id: string;
  name: string;
  desc: string;
  price: number;
  imageUrl: string;
  quantity?: number;
};

export type DetailedItem = Item & {
  brand: string;
  model: string;
  weight: number;
  specifications: { [key: string]: string | number }[];
};
