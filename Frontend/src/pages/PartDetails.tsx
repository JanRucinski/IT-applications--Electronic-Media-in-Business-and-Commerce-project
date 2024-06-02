import { useParams } from 'react-router-dom';

import ItemDetails from '@/components/shop/ItemDetails';
import { useItem } from '@/hooks/use-items';
import ErrorState from '@/components/shared/ErrorState';
import LoadingState from '@/components/shared/LoadingState';

const PartDetails = () => {
  const { id } = useParams<{ id: string }>();
  const { data, error, isLoading } = useItem(id as string);

  if (isLoading) {
    return <LoadingState />;
  }

  if (error) {
    return <ErrorState errorLabel="Failed to fetch this bike part." />;
  }
  return <ItemDetails item={data} itemCategory="parts" />;
};

export default PartDetails;
