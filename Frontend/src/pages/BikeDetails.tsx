import { useParams } from 'react-router-dom';

import ItemDetails from '@/components/shop/ItemDetails';
import { useItem } from '@/hooks/use-items';
import LoadingState from '@/components/shared/LoadingState';
import ErrorState from '@/components/shared/ErrorState';

const BikeDetails = () => {
  const { id } = useParams<{ id: string }>();
  const { data, error, isLoading } = useItem(id as string);

  if (isLoading) {
    return <LoadingState />;
  }

  if (error) {
    return <ErrorState errorLabel="Failed to fetch this bike." />;
  }

  return <ItemDetails item={data} itemCategory="bikes" />;
};

export default BikeDetails;
