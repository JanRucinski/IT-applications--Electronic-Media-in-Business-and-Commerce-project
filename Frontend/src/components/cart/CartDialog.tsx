import { useMemo } from 'react';
import { Link } from 'react-router-dom';
import { ArrowRightIcon } from 'lucide-react';

import {
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';
import { CartItem } from './CartItem';
import { Button } from '../ui/button';
import { CartItemType } from '@/models/cart-item';

type CartDialogProps = {
  items: CartItemType[];
  onClose: () => void;
};

export const CartDialog = ({ items, onClose }: CartDialogProps) => {
  const isEmpty = !items.length;

  const totalCost = useMemo(
    () =>
      items.reduce((acc, item) => acc + item.price * item.selectedQuantity, 0),
    [items]
  );

  return (
    <DialogContent className="max-w-[90%] md:w-full sm:max-w-md min-w-min max-h-[92%] overflow-y-scroll text-center md:text-start rounded-lg">
      <DialogHeader>
        <DialogTitle className="text-xl md:text-2xl text-sky-950">
          Shopping Cart
        </DialogTitle>
        <DialogDescription>{isEmpty && 'Your cart is empty'}</DialogDescription>
      </DialogHeader>
      {!isEmpty && (
        <ul className="space-y-6 md:space-y-3">
          {items.map((item) => (
            <CartItem item={item} key={item.id} />
          ))}
        </ul>
      )}
      <DialogFooter>
        {isEmpty ? (
          <Button asChild className="flex-1">
            <Link to="/bikes" onClick={onClose}>
              Explore our shop
            </Link>
          </Button>
        ) : (
          <div className="flex-1 mt-4 flex justify-between items-center gap-4">
            <span className="text-2xl px-6 text-sky-950" id="cart-total-price">
              {totalCost.toFixed(2)}$
            </span>
            <Button className="flex-1" id="checkout-btn" asChild>
              <Link to="/checkout/order" onClick={onClose}>
                Checkout
                <ArrowRightIcon size={18} className="ml-2" />
              </Link>
            </Button>
          </div>
        )}
      </DialogFooter>
    </DialogContent>
  );
};
