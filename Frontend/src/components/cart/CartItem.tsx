import { PlusIcon, MinusIcon } from 'lucide-react';

import { CartItemType } from '@/models/cart-item';
import { Button } from '../ui/button';
import { useCartStore } from '@/store/cart';

type CartItemProps = {
  item: CartItemType;
};

export const CartItem = ({ item }: CartItemProps) => {
  const { removeItem, updateItem } = useCartStore();

  const increment = () => {
    updateItem(item.id, item.selectedQuantity + 1);
  };

  const decrement = () => {
    if (item.selectedQuantity === 1) {
      removeItem(item.id);
      return;
    }
    updateItem(item.id, item.selectedQuantity - 1);
  };

  return (
    <li className="flex flex-col md:flex-row justify-between items-center shadow-md py-4 md:px-6 rounded-lg gap-2 md:gap-4">
      <img
        src={item.imageUrl}
        alt={item.name}
        className="w-32 h-24 object-contain rounded-lg border p-1"
      />
      <div className="flex-1 md:mx-4 p-1 md:w-96">
        <h4 className="text-lg font-semibold text-sky-950">{item.name}</h4>
        <p className="text-muted-foreground">
          {(item.price * item.selectedQuantity).toFixed(2)}$
        </p>
      </div>
      <div className="flex">
        <Button
          onClick={decrement}
          size="icon"
          variant="outline"
          className="rounded-full text-primary hover:text-sky-950"
        >
          <MinusIcon size={24} />
        </Button>
        <span className="h-10 w-10 flex justify-center items-center text-xl text-sky-950">
          {item.selectedQuantity}
        </span>
        <Button
          size="icon"
          onClick={increment}
          disabled={item.selectedQuantity === item.quantity}
          variant="outline"
          className="rounded-full text-primary hover:text-sky-950"
        >
          <PlusIcon size={24} />
        </Button>
      </div>
    </li>
  );
};
