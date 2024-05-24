import { CartItemType } from '@/models/cart-item';
import { Item } from '@/models/item';
import { ItemCategory } from '@/types/config';

export const createCartItem = (item: Item) =>
  ({
    id: item.id,
    name: item.name,
    price: item.price,
    image: item.image,
    quantity: 1,
    maxQuantity: item.maxQuantity ? item.maxQuantity : 1,
  } as CartItemType);

export const createBreadcrumb = (itemCategory: ItemCategory) => {
  switch (itemCategory) {
    case 'shop':
      return [
        {
          name: 'Shop',
          url: `/${itemCategory}`,
        },
      ];
    case 'parts':
      return [
        {
          name: 'Parts',
          url: `/${itemCategory}`,
        },
      ];
    default:
      return [];
  }
};
