import { Navigate, useLocation, useNavigate } from 'react-router-dom';
import { toast } from 'sonner';

import { useAuth } from '@/store/user';
import { PaymentMethod } from './PaymentMethod';
import { Payment, PaymentStatus, RentalStatus } from '@/constants/status-enums';
import { rentItem } from '@/services/rentals';

type LocationState = {
  itemId: string;
  rentalStart: string;
  rentalEnd: string;
  total: number;
};

const RentalCheckout = () => {
  const { user } = useAuth();
  const navigate = useNavigate();
  const location = useLocation() as { state: LocationState };

  if (!user) {
    return <Navigate to="/login?checkout=rental" />;
  }

  const { itemId, rentalStart, rentalEnd, total } = location.state;

  if (!itemId || !rentalStart || !rentalEnd || !total) {
    navigate('/rental');
  }

  const handlePayment = async (payment: Payment) => {
    try {
      await rentItem({
        rentalStart,
        rentalEnd,
        total,
        itemId,
        status: RentalStatus.REQUESTED,
        payment: {
          amount: total,
          provider: payment,
          status: PaymentStatus.PENDING,
        },
      });
      toast.success('Item rented successfully');
      await new Promise((resolve) =>
        setTimeout(() => {
          resolve(true);
          navigate('/rental');
        }, 1000)
      );
    } catch (error) {
      toast.error('Failed to rent item. Please try again.');
    }
  };

  return <PaymentMethod onSubmit={handlePayment} />;
};

export default RentalCheckout;
