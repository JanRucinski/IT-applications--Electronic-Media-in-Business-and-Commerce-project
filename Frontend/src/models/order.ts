import { OrderStatus, Payment, PaymentStatus } from '@/constants/status-enums';

export type Order = {
  id?: string;
  total: number;
  status: OrderStatus;
  payment: {
    amount: number;
    provider: Payment;
    status: PaymentStatus;
  };
  orderItems: {
    itemId: string;
    quantity: string;
  }[];
};
