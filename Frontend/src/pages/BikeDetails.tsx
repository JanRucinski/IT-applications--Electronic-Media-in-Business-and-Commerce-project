import { useParams } from 'react-router-dom';

import ItemDetails from '@/components/shop/ItemDetails';
import { mockedBike, mockedBikes } from '@/config/mock';
import { DetailedBikeItem } from '@/models/item';

const BikeDetails = () => {
  const { id } = useParams<{ id: string }>();

  const item = mockedBikes.find((bike) => bike.id === id);

  if (!item) {
    return <div>Item not found</div>;
  }

  // !TEMP MOCK
  const bike = {
    ...item,
    ...mockedBike,
  } as DetailedBikeItem;

  return <ItemDetails item={bike} itemCategory="bikes" />;
};

export default BikeDetails;
