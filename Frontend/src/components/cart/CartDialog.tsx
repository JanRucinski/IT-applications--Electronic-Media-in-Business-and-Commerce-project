import {
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
} from '@/components/ui/dialog';

import { CartItemType } from '@/models/cart-item';
import { CartItem } from './CartItem';
import { Button } from '../ui/button';
import { Link } from 'react-router-dom';

type CartDialogProps = {
  items: CartItemType[];
  onClose: () => void;
};

export const CartDialog = ({ items, onClose }: CartDialogProps) => {
  return (
    <DialogContent>
      <DialogHeader>
        <DialogTitle>Cart</DialogTitle>
        <DialogDescription>
          {items.length ? 'Items inside cart:' : 'Your cart is empty'}
        </DialogDescription>
      </DialogHeader>
      {items.length ? (
        <div>
          <ul>
            {items.map((item) => (
              <CartItem item={item} />
            ))}
          </ul>
          <Button className="mt-4">Checkout</Button>
        </div>
      ) : (
        <Button asChild>
          <Link to="/shop" onClick={onClose}>
            Explore our shop
          </Link>
        </Button>
      )}
    </DialogContent>
  );
};
