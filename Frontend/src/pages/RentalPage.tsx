import { isMobile } from 'react-device-detect';
import { useSearchParams } from 'react-router-dom';

import RentItem from '@/components/rent/RentItem';
import ErrorState from '@/components/shared/ErrorState';
import LoadingState from '@/components/shared/LoadingState';
import { useRentItems } from '@/hooks/use-items';
import { Item } from '@/models/item';
import ItemsPagination from '@/components/shared/ItemsPagination';

const RentalPage = () => {
  const [params] = useSearchParams();
  const page = params.get('page') ?? 1;

  const { data, error, isLoading } = useRentItems(+page);

  if (isLoading) {
    return <LoadingState />;
  }

  if (error) {
    return <ErrorState errorLabel="Failed to fetch rentals." />;
  }

  if (!data?.content?.length) {
    return (
      <div className="flex-1 flex justify-center items-center">
        <h1 className="text-xl md:text-2xl text-center text-sky-950">
          Seems like there are no rentals available at the moment. Please check
          back later.
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
              Rent a bike for your next adventure
            </h2>
            <p className="text-lg mt-2 text-muted-foreground">
              Choose from a variety of bikes to rent for your next trip.
            </p>
          </div>
        )}
      </div>
      <div className="grid md:grid-cols-4 gap-6 md:gap-10 my-4">
        {data.content.map((item: Item) => (
          <RentItem key={item.id} item={item} />
        ))}
      </div>
      {data.totalPages > 1 && (
        <ItemsPagination
          totalPages={data.totalPages}
          currentPage={+page}
          className="mt-16"
        />
      )}
    </section>
  );
};

export default RentalPage;
