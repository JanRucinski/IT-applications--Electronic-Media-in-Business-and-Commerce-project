import { DateRange } from 'react-day-picker';
import { differenceInCalendarDays } from 'date-fns';

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

export const calculateRentPrice = (
  date: DateRange | undefined,
  price: number
): number => {
  if (!date || !date.from || !date.to) {
    return 0;
  }

  const from = date.from;
  const to = date.to;
  const diffDays = differenceInCalendarDays(to, from);

  return (diffDays > 0 ? diffDays : 1) * price;
};
