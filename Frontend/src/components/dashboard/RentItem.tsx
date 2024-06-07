import { format } from 'date-fns';

import { Rental } from '@/models/rental';

const RentItem = ({ rental }: { rental: Rental }) => {
  const { id, status, total, rentalStart, rentalEnd, payment } = rental;

  const start = format(new Date(rentalStart), 'dd/MM/yyyy');
  const end = format(new Date(rentalEnd), 'dd/MM/yyyy');

  return (
    <div className="p-4 border rounded-lg shadow-md bg-white">
      <h1 className="text-2xl font-bold mb-2">Rental: {id}</h1>
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
        <strong>Rent Dates:</strong> {start} - {end}
      </p>
    </div>
  );
};

export default RentItem;
