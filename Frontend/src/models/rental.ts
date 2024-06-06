import { Payment, PaymentStatus, RentalStatus } from '@/constants/status-enums';

export type Rental = {
  id?: string;
  rentalStart: string;
  rentalEnd: string;
  total: number;
  status: RentalStatus;
  itemId: string;
  payment: {
    amount: number;
    provider: Payment;
    status: PaymentStatus;
  };
};
