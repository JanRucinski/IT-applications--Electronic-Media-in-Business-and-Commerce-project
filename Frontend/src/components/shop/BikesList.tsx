import { useSearchParams } from 'react-router-dom';

import { useBikes } from '@/hooks/use-items';
import ShopItem from './ShopItem';
import LoadingState from '../shared/LoadingState';
import ErrorState from '../shared/ErrorState';
import { Item } from '@/models/item';
import NotFoundState from '../shared/NotFoundState';

type BikesListProps = {
  isAdmin?: boolean;
};

const BikesList = ({ isAdmin }: BikesListProps) => {
  const [params] = useSearchParams();
  const query = params.get('name') || '';

  const { data, error, isLoading } = useBikes(query);

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

  if (!data.length) {
    return <NotFoundState />;
  }

  return (
    <div className="grid md:grid-cols-4 gap-6 md:gap-10 my-4">
      {data.map((item: Item) => (
        <ShopItem
          key={item.id}
          item={item}
          itemCategory="bikes"
          isAdmin={isAdmin}
        />
      ))}
    </div>
  );
};

export default BikesList;
