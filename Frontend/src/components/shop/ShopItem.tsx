import { Link } from 'react-router-dom';

import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from '@/components/ui/card';
import { Button } from '../ui/button';
import { Item } from '@/models/item';
import { ItemCategory } from '@/types/config';
import { useManageCartItem } from '@/hooks/use-common-actions';
import ItemActionFooter from '../dashboard/items/ItemActionFooter';

type ShopItemProps = {
  item: Item;
  itemCategory: ItemCategory;
  isAdmin?: boolean;
};

const ShopItem = ({ item, itemCategory, isAdmin }: ShopItemProps) => {
  const { isItemInCart, buttonAction, buttonLabel } = useManageCartItem(item);

  return (
    <Card className="flex flex-col justify-between">
      <CardHeader>
        <CardTitle>{item.name}</CardTitle>
        <CardDescription>{item.desc}</CardDescription>
      </CardHeader>
      <CardContent>
        <div>
          <div>
            <img
              className="w-64 h-64 object-contain rounded-lg"
              src={item.imageUrl}
              alt={item.name}
            />
          </div>
          <div>
            <p className="text-sky-950 font-bold text-xl mt-5">${item.price}</p>
          </div>
        </div>
      </CardContent>
      {isAdmin ? (
        <ItemActionFooter itemCategory={itemCategory} item={item} />
      ) : (
        <CardFooter className="flex justify-between gap-4">
          <Button
            className="flex-1"
            onClick={buttonAction}
            variant={isItemInCart ? 'outline' : 'default'}
          >
            {buttonLabel}
          </Button>
          <Button variant="link" className="text-sky-950" asChild>
            <Link to={`/${itemCategory}/${item.id}`}>Details</Link>
          </Button>
        </CardFooter>
      )}
    </Card>
  );
};

export default ShopItem;
