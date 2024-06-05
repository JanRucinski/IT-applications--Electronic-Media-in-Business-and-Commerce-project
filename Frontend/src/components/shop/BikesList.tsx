import { useSearchParams } from 'react-router-dom';
import { useEffect } from 'react';

import { useBikes } from '@/hooks/use-items';
import ShopItem from './ShopItem';
import LoadingState from '../shared/LoadingState';
import ErrorState from '../shared/ErrorState';
import { Item } from '@/models/item';
import NotFoundState from '../shared/NotFoundState';
import ItemsPagination from '../shared/ItemsPagination';
import { SortEnum } from '@/constants/sorting-filters';
import { getSortedItems } from '@/utils/sort';

type BikesListProps = {
  isAdmin?: boolean;
};

const BikesList = ({ isAdmin }: BikesListProps) => {
  const [params] = useSearchParams();
  const nameQuery = params.get('name') || '';
  const page = params.get('page') ?? 1;
  const sort = (params.get('sort') as SortEnum) || '';
  const category = params.get('category') || '';

  const { data, error, isLoading } = useBikes(+page, nameQuery, category);

  useEffect(() => {
    window.scrollTo(0, 0);
  }, [page, nameQuery]);

  if (isLoading) {
    return <LoadingState className="h-32 md:h-96" spinnerSize={16} />;
  }

  if (error) {
    return (
      <div className="mt-10 md:mt-52">
        <ErrorState errorLabel="Failed to fetch bikes." />
      </div>
    );
  }

  if (!data?.content?.length) {
    return <NotFoundState />;
  }

  const bikes = getSortedItems(data.content, sort);

  return (
    <>
      <div className="grid md:grid-cols-4 gap-6 md:gap-10 my-4">
        {bikes.map((item: Item) => (
          <ShopItem
            key={item.id}
            item={item}
            itemCategory="bikes"
            isAdmin={isAdmin}
          />
        ))}
      </div>
      {data.totalPages > 1 && (
        <ItemsPagination
          totalPages={data.totalPages}
          currentPage={+page}
          className="mt-16"
        />
      )}
    </>
  );
};

export default BikesList;
