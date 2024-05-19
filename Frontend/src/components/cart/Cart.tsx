import { useState } from 'react';
import { ShoppingCartIcon } from 'lucide-react';
import { Dialog, DialogTrigger } from '@/components/ui/dialog';
import { Button } from '../ui/button';

import { useCart } from '@/hooks/use-cart';
import { CartDialog } from './CartDialog';

const Cart = () => {
  const { cart } = useCart();
  const [open, setOpen] = useState(false);

  return (
    <div className="mr-2 px-4 flex items-center justify-center">
      <Dialog open={open} onOpenChange={setOpen}>
        <DialogTrigger asChild>
          <Button variant="nav" size="link" className="relative">
            <ShoppingCartIcon size={24} />
            {!!cart.length && (
              <span className="absolute top-0 right-0 transform translate-x-1/2 -translate-y-1/2 bg-red-500 text-white text-xs rounded-full w-5 h-5 flex items-center justify-center">
                {cart.length}
              </span>
            )}
          </Button>
        </DialogTrigger>
        <CartDialog items={cart} onClose={() => setOpen(false)} />
      </Dialog>
    </div>
  );
};

export default Cart;
