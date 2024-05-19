import { CartItemType } from '@/models/cart-item';
import { Button } from '../ui/button';
import { useCartStore } from '@/hooks/context/use-cart-store';

type CartItemProps = {
  item: CartItemType;
};

export const CartItem = ({ item }: CartItemProps) => {
  const { removeItem, updateItem } = useCartStore();

  const increment = () => {
    updateItem(item.id, item.quantity + 1);
  };

  const decrement = () => {
    if (item.quantity === 1) {
      removeItem(item.id);
      return;
    }
    updateItem(item.id, item.quantity - 1);
  };

  return (
    <li>
      {item.quantity} x {item.name}
      <div>{item.price * item.quantity} €</div>
      <Button onClick={() => removeItem(item.id)}>Remove item</Button>
      <div>
        <Button onClick={decrement}>-</Button>
        <Button
          onClick={increment}
          disabled={item.maxQuantity === item.quantity}
        >
          +
        </Button>
      </div>
    </li>
  );
};
