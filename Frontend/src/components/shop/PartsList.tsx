import { useSearchParams } from 'react-router-dom';

import { useParts } from '@/hooks/use-items';
import ShopItem from './ShopItem';
import LoadingState from '../shared/LoadingState';
import ErrorState from '../shared/ErrorState';
import { Item } from '@/models/item';
import NotFoundState from '../shared/NotFoundState';

const PartsList = () => {
  const [params] = useSearchParams();
  const query = params.get('name') || '';

  const { data, error, isLoading } = useParts(query);
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

  if (!data.length) {
    return <NotFoundState />;
  }

  return (
    <div className="grid md:grid-cols-4 md:gap-10 my-4">
      {data.map((item: Item) => (
        <ShopItem key={item.id} item={item} itemCategory="parts" />
      ))}
    </div>
  );
};

export default PartsList;
