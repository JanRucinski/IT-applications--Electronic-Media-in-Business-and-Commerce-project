import { isMobile } from 'react-device-detect';

import { useOrders } from '@/hooks/use-orders';
import LoadingState from '../shared/LoadingState';
import ErrorState from '../shared/ErrorState';
import { Order } from '@/models/order';
import OrderItem from './OrderItem';

const Orders = ({ isAdmin }: { isAdmin?: boolean }) => {
  const { data, isLoading, error } = useOrders();

  if (isLoading) return <LoadingState />;

  if (error) return <ErrorState errorLabel="Failed to load orders" />;

  if (!data?.length) {
    return (
      <div className="flex-1 flex justify-center items-center">
        <h1 className="text-xl md:text-2xl text-center text-sky-950">
          {!isAdmin
            ? 'You have not placed any orders yet.'
            : 'No orders placed yet.'}
        </h1>
      </div>
    );
  }

  return (
    <section className="container">
      <div className="mt-5 mb-6 md:mb-10 flex justify-between">
        {!isMobile && (
          <div className="text-center mx-auto">
            <h2 className="text-3xl font-semibold">
              {!isAdmin ? 'Your orders' : 'Orders'}
            </h2>
            <p className="text-lg mt-2 text-muted-foreground">
              {isAdmin
                ? 'View all orders placed by customers.'
                : 'View your recent orders and track their status.'}
            </p>
          </div>
        )}
      </div>
      <div className="space-y-3">
        {data.map((order: Order & { createdAt: string }) => (
          <OrderItem key={order.id} order={order} />
        ))}
      </div>
    </section>
  );
};

export default Orders;
