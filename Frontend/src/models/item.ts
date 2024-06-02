export type Item = {
  id: string;
  name: string;
  desc: string;
  price: number;
  image: string;
  quantity?: number;
};

export type DetailedItem = Item & {
  brand: string;
  model: string;
  weight: number;
  specifications: { [key: string]: string | number }[];
};
