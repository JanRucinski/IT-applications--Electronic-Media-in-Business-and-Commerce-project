import { useParams } from 'react-router-dom';

import { mockedBikeParts, mockedPart } from '@/config/mock';
import ItemDetails from '@/components/shop/ItemDetails';
import { DetailedPartItem } from '@/models/item';

const PartDetails = () => {
  const { id } = useParams<{ id: string }>();

  const part = mockedBikeParts.find((part) => part.id === id);

  if (!part) {
    return <div>Part not found</div>;
  }

  // !TEMP MOCK
  const item = {
    ...part,
    ...mockedPart,
  } as DetailedPartItem;

  return <ItemDetails item={item} itemCategory="parts" />;
};

export default PartDetails;
