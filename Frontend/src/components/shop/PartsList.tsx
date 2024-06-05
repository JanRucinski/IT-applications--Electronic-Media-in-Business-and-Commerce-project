import { useSearchParams } from 'react-router-dom';

import { useParts } from '@/hooks/use-items';
import ShopItem from './ShopItem';
import LoadingState from '../shared/LoadingState';
import ErrorState from '../shared/ErrorState';
import { Item } from '@/models/item';
import NotFoundState from '../shared/NotFoundState';
import { useEffect } from 'react';
import ItemsPagination from '../shared/ItemsPagination';

type PartsListProps = {
  isAdmin?: boolean;
};

const PartsList = ({ isAdmin }: PartsListProps) => {
  const [params] = useSearchParams();
  const nameQuery = params.get('name') || '';
  const page = params.get('page') ?? 1;

  const { data, error, isLoading } = useParts(+page, nameQuery);

  useEffect(() => {
    window.scrollTo(0, 0);
  }, [page, nameQuery]);

  if (isLoading) {
    return <LoadingState className="h-96" spinnerSize={16} />;
  }

  if (error) {
    return (
      <div className="mt-10 md:mt-52">
        <ErrorState errorLabel="Failed to fetch parts for bikes." />
      </div>
    );
  }

  if (!data?.content?.length) {
    return <NotFoundState />;
  }

  return (
    <>
      <div className="grid md:grid-cols-4 gap-6 md:gap-10 my-4">
        {data.content.map((item: Item) => (
          <ShopItem
            key={item.id}
            item={item}
            itemCategory="parts"
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

export default PartsList;
