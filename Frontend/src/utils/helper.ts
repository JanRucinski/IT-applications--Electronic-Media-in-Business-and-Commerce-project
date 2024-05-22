import { CartItemType } from '@/models/cart-item';
import { Item } from '@/models/item';

export const createCartItem = (item: Item) =>
  ({
    id: item.id,
    name: item.name,
    price: item.price,
    image: item.image,
    quantity: 1,
    maxQuantity: item.maxQuantity ? item.maxQuantity : 1,
  } as CartItemType);
