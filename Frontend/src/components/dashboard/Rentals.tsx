import { isMobile } from 'react-device-detect';

import LoadingState from '../shared/LoadingState';
import ErrorState from '../shared/ErrorState';
import { useRentals } from '@/hooks/use-rentals';
import { Rental } from '@/models/rental';
import RentItem from './RentItem';

const Rentals = ({ isAdmin }: { isAdmin?: boolean }) => {
  const { data, isLoading, error } = useRentals();

  if (isLoading) return <LoadingState />;

  if (error) return <ErrorState errorLabel="Failed to load rentals" />;

  if (!data?.length) {
    return (
      <div className="flex-1 flex justify-center items-center">
        <h1 className="text-xl md:text-2xl text-center text-sky-950">
          {!isAdmin
            ? 'You have not rented any bikes yet.'
            : 'No rentals placed yet.'}
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
              {isAdmin ? 'Rentals' : 'Your Rentals'}
            </h2>
            <p className="text-lg mt-2 text-muted-foreground">
              {!isAdmin
                ? 'View your recent rentals and track their status.'
                : 'View all rentals placed by customers.'}
            </p>
          </div>
        )}
      </div>
      <div className="space-y-3">
        {data.map((rental: Rental) => (
          <RentItem key={rental.id} rental={rental} />
        ))}
      </div>
    </section>
  );
};

export default Rentals;
