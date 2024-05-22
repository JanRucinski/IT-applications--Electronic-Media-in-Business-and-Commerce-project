import { useParams } from 'react-router-dom';

import ItemDetails from '@/components/shop/ItemDetails';
import { mockedBikes } from '@/config/mock';

const ShopItemDetails = () => {
  const { id } = useParams<{ id: string }>();

  const item = mockedBikes.find((bike) => bike.id === id);

  if (!item) {
    return <div>Item not found</div>;
  }

  return (
    <section>
      <ItemDetails item={item} />
    </section>
  );
};

export default ShopItemDetails;
