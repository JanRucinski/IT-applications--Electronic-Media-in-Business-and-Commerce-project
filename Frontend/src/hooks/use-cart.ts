import { CartItemType } from '@/models/cart-item';
import { useLocalStorage } from './use-local-storage';

export const useCart = () => {
  const [cart, setCart] = useLocalStorage<CartItemType[]>('cart', []);

  const addItem = (item: CartItemType) => {
    setCart([...cart, item]);
  };

  const removeItem = (id: string) => {
    setCart(cart.filter((item) => item.id !== id));
  };

  const updateItem = (id: string, quantity: number) => {
    setCart(
      cart.map((item) =>
        item.id === id
          ? {
              ...item,
              quantity,
            }
          : item
      )
    );
  };

  return { cart, addItem, removeItem, updateItem };
};
