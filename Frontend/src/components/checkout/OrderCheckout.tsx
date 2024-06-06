import { useMemo } from 'react';
import { Navigate, useNavigate } from 'react-router-dom';
import { toast } from 'sonner';

import { useAuth } from '@/store/user';
import { PaymentMethod } from './PaymentMethod';
import { Payment, PaymentStatus, OrderStatus } from '@/constants/status-enums';
import { useCartStore } from '@/store/cart';
import { createOrder } from '@/services/orders';

const OrderCheckout = () => {
  const { user } = useAuth();
  const { cart, resetCart } = useCartStore();
  const navigate = useNavigate();

  const orderItems = useMemo(
    () =>
      cart.map((item) => ({
        itemId: item.id,
        quantity: item.selectedQuantity.toString(),
      })),
    [cart]
  );

  const total = useMemo(
    () =>
      cart.reduce((acc, item) => {
        return acc + item.price * item.selectedQuantity;
      }, 0),
    [cart]
  );

  if (!user) {
    return <Navigate to="/login?checkout=true" />;
  }

  const handlePayment = async (payment: Payment) => {
    try {
      await createOrder({
        total,
        status: OrderStatus.PENDING,
        payment: {
          amount: total,
          provider: payment,
          status: PaymentStatus.PENDING,
        },
        orderItems,
      });
      resetCart();
      toast.success('Order created successfully');
      await new Promise((resolve) =>
        setTimeout(() => {
          resolve(true);
          navigate('/bikes');
        }, 1000)
      );
    } catch (error) {
      toast.error('Failed to create order');
    }
  };

  return <PaymentMethod onSubmit={handlePayment} />;
};

export default OrderCheckout;
