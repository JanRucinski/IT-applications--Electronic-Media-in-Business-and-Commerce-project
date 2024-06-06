import { useMemo } from 'react';

import { Item } from '@/models/item';
import { useCartStore } from '@/store/cart';
import { createCartItem } from '@/utils/helper';
import { useSearchParams } from 'react-router-dom';

export const useManageCartItem = (item: Item) => {
  const { cart, addItem, removeItem } = useCartStore();
  const { id } = item;

  const isItemInCart = useMemo(
    () => cart.some((cartItem) => cartItem.id === id),
    [cart, id]
  );

  const buttonLabel = isItemInCart ? 'Remove from Cart' : 'Add to Cart';
  const buttonAction = isItemInCart
    ? () => removeItem(id)
    : () => addItem(createCartItem({ ...item }));

  return { isItemInCart, buttonLabel, buttonAction, cart };
};

export const useResetSearchParams = () => {
  const [searchParams, setSearchParams] = useSearchParams();

  const reset = () => {
    setSearchParams({});
  };

  return { reset, searchParams };
};
