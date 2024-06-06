import { DetailedItem } from '@/models/item';
import { createBreadcrumb } from '@/utils/helper';
import { NavBreadcrumb } from '../shared/NavBreadcrumb';
import { ItemCategory } from '@/types/config';
import { useManageCartItem } from '@/hooks/use-common-actions';
import { Button } from '../ui/button';
import { isMobile } from 'react-device-detect';

type ItemDetailsProps = {
  item: DetailedItem;
  itemCategory: ItemCategory;
};

const ItemDetails = ({ item, itemCategory }: ItemDetailsProps) => {
  const { isItemInCart, buttonAction, buttonLabel } = useManageCartItem(item);

  const itemDisabled = item.quantity === 0;

  return (
    <div className="container flex flex-col flex-1">
      <NavBreadcrumb
        containerClasses="mt-2 mb-2 md:mt-5 md:mb-5"
        currentPage={item.name}
        breadcrumbs={createBreadcrumb(itemCategory)}
      />
      <div className="container items-center justify-center flex mt-4 md:mt-20 flex-1">
        <section className="flex flex-col md:flex-row gap-8 justify-center items-center">
          <div className="flex justify-center md:justify-start">
            <img
              className="w-64 h-52 p-4 md:w-96 md:h-80 object-contain rounded-lg shadow-lg border overflow-hidden"
              src={item.imageUrl}
              alt={item.name}
            />
          </div>
          <div className="flex-1 md:space-y-4 md:px-8">
            <div>
              <h1 className="text-2xl md:text-4xl font-semibold">
                {item.name}
              </h1>
              <p className="text-base md:text-lg text-muted-foreground">
                {item.desc}
              </p>
              <p className="text-xl mt-2 text-center md:text-start md:text-3xl font-bold md:mt-5">
                ${item.price}
              </p>
              <p className="text-center md:text-start text-base md:text-lg text-gray-700 mt-2 md:mt-5">
                Max: {item.quantity} items
              </p>
              <p className="text-lg text-gray-700 mt-5">{item.brand}</p>
              <p className="text-lg text-gray-700">{item.model}</p>
            </div>
            <Button
              onClick={buttonAction}
              className={isMobile ? 'w-full mb-4' : undefined}
              variant={isItemInCart ? 'outline' : 'default'}
              disabled={itemDisabled}
            >
              {itemDisabled ? 'Not Available' : buttonLabel}
            </Button>
          </div>
        </section>
      </div>
    </div>
  );
};

export default ItemDetails;
