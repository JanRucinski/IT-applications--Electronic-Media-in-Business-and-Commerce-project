import { format } from 'date-fns';
import { Order } from '@/models/order';

const OrderItem = ({ order }: { order: Order & { createdAt: string } }) => {
  const { id, status, total, createdAt, payment } = order;

  const formattedDate = format(new Date(createdAt), 'dd/MM/yyyy');

  return (
    <div className="p-4 border rounded-lg shadow-md bg-white">
      <h1 className="text-2xl font-bold mb-2">Order: {id}</h1>
      <p className="text-lg text-gray-700 mb-1">
        <strong>Status:</strong> {status}
      </p>
      <p className="text-lg text-gray-700 mb-1">
        <strong>Payment Method:</strong> {payment.provider}
      </p>
      <p className="text-lg text-gray-700 mb-1">
        <strong>Total:</strong> ${total.toFixed(2)}
      </p>
      <p className="text-lg text-gray-700">
        <strong>Date:</strong> {formattedDate}
      </p>
    </div>
  );
};

export default OrderItem;
