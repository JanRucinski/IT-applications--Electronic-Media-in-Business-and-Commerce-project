import { useMemo } from 'react';

import { Item } from '@/models/item';
import { useCartStore } from '@/store/cart';
import { createCartItem } from '@/utils/helper';

type ItemDetailsProps = {
  item: Item;
};

const ItemDetails = ({ item }: ItemDetailsProps) => {
  const { cart, addItem, removeItem } = useCartStore();
  const { id } = item;

  const isInCart = useMemo(
    () => cart.some((cartItem) => cartItem.id === id),
    [cart, id]
  );

  return (
    <div>
      <div>
        <img
          className="w-64 h-64 object-contain rounded-lg"
          src={item.image}
          alt={item.name}
        />
      </div>
      <div>
        <p className="text-sky-950 font-bold text-xl mt-5">${item.price}</p>
      </div>
      <div className="flex justify-between gap-4">
        {isInCart ? (
          <button onClick={() => removeItem(id)}>Remove from cart</button>
        ) : (
          <button
            onClick={() =>
              addItem(
                createCartItem({
                  ...item,
                })
              )
            }
          >
            Add to cart
          </button>
        )}
      </div>
    </div>
  );
};

export default ItemDetails;
