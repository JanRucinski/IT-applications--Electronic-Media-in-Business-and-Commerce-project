import { DetailedItem } from '@/models/item';
import { createBreadcrumb } from '@/utils/helper';
import { NavBreadcrumb } from '../shared/NavBreadcrumb';
import { ItemCategory } from '@/types/config';
import { useManageCartItem } from '@/hooks/use-common-actions';
import { Button } from '../ui/button';

type ItemDetailsProps = {
  item: DetailedItem;
  itemCategory: ItemCategory;
};

const ItemDetails = ({ item, itemCategory }: ItemDetailsProps) => {
  const { isItemInCart, buttonAction, buttonLabel } = useManageCartItem(item);

  return (
    <div className="container flex flex-col flex-1">
      <NavBreadcrumb
        containerClasses="mt-5 mb-5"
        currentPage={item.name}
        breadcrumbs={createBreadcrumb(itemCategory)}
      />
      <div className="container items-center justify-center flex mt-20 flex-1">
        <section className="flex flex-col md:flex-row gap-8 justify-center items-center">
          <div className="flex justify-center md:justify-start">
            <img
              className="w-full md:w-96 h-80 object-contain rounded-lg shadow-lg border overflow-hidden"
              src={item.image}
              alt={item.name}
            />
          </div>
          <div className="flex-1 space-y-4 px-8">
            <div>
              <h1 className="text-4xl font-semibold">{item.name}</h1>
              <p className="text-lg text-muted-foreground">{item.desc}</p>
              <p className="text-3xl font-bold mt-5">${item.price}</p>
              <p className="text-lg text-gray-700 mt-5">
                Max: {item.quantity} items
              </p>
              <p className="text-lg text-gray-700 mt-5">{item.brand}</p>
              <p className="text-lg text-gray-700">{item.model}</p>
            </div>
            <Button
              onClick={buttonAction}
              variant={isItemInCart ? 'outline' : 'default'}
            >
              {buttonLabel}
            </Button>
          </div>
        </section>
      </div>
    </div>
  );
};

export default ItemDetails;
