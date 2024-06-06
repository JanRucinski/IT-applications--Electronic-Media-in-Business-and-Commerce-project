import { Button } from '../ui/button';
import {
  Card,
  CardContent,
  CardDescription,
  CardFooter,
  CardHeader,
  CardTitle,
} from '../ui/card';
import { Item } from '@/models/item';
import RentAction from './RentAction';
import ShopItemFooter from '../dashboard/items/ShopItemFooter';

type RentItemProps = {
  item: Item;
  isAdmin?: boolean;
};

const RentItem = ({ item, isAdmin }: RentItemProps) => {
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
            <p className="text-sky-950 font-bold text-xl mt-5">
              ${item.price} / day
            </p>
          </div>
        </div>
      </CardContent>
      {isAdmin ? (
        <ShopItemFooter item={item} itemCategory="rental" />
      ) : (
        <CardFooter>
          <RentAction bikeId={item.id}>
            <Button className="flex-1" id="checkout-btn">
              Rent now
            </Button>
          </RentAction>
        </CardFooter>
      )}
    </Card>
  );
};

export default RentItem;
