import { create } from 'zustand';
import { persist } from 'zustand/middleware';

import { CartItemType } from '@/models/cart-item';

interface CartState {
  cart: CartItemType[];
  addItem: (item: CartItemType) => void;
  removeItem: (id: string) => void;
  updateItem: (id: string, selectedQuantity: number) => void;
  resetCart: () => void;
}

export const useCartStore = create<CartState>()(
  persist(
    (set) => ({
      cart: [],
      addItem: (item) => set((state) => ({ cart: [...state.cart, item] })),
      removeItem: (id) =>
        set((state) => ({ cart: state.cart.filter((item) => item.id !== id) })),
      updateItem: (id, selectedQuantity) =>
        set((state) => ({
          cart: state.cart.map((item) =>
            item.id === id ? { ...item, selectedQuantity } : item
          ),
        })),
      resetCart: () => set({ cart: [] }),
    }),
    {
      name: 'cart',
    }
  )
);
