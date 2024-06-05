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
    imageUrl: item.imageUrl,
    selectedQuantity: 1,
    quantity: item.quantity ? item.quantity : 1,
  } as CartItemType);

export const createBreadcrumb = (itemCategory: ItemCategory) => {
  switch (itemCategory) {
    case 'bikes':
      return [
        {
          name: 'Bikes',
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

export const sortByPrice = (items: Item[], order: 'asc' | 'desc') => {
  return items.sort((a, b) => {
    if (order === 'asc') {
      return a.price - b.price;
    }
    return b.price - a.price;
  });
};

export const sortByName = (items: Item[], order: 'asc' | 'desc') => {
  return items.sort((a, b) => {
    if (order === 'asc') {
      return a.name.localeCompare(b.name);
    }
    return b.name.localeCompare(a.name);
  });
};
