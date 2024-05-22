import { useParams } from 'react-router-dom';

import { mockedBikeParts } from '@/config/mock';
import ItemDetails from '@/components/shop/ItemDetails';

const PartDetails = () => {
  const { id } = useParams<{ id: string }>();

  const part = mockedBikeParts.find((part) => part.id === id);

  if (!part) {
    return <div>Part not found</div>;
  }

  return (
    <section>
      <ItemDetails item={part} />
    </section>
  );
};

export default PartDetails;
