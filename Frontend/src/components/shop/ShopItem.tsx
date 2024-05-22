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
import { Link } from 'react-router-dom';
import { useCartStore } from '@/store/cart';
import { createCartItem } from '@/utils/helper';

type ShopItemProps = {
  item: Item;
  type: 'shop' | 'parts';
};

const ShopItem = ({ item, type }: ShopItemProps) => {
  const { addItem, removeItem, cart } = useCartStore();

  return (
    <Card className="flex flex-col justify-between">
      <CardHeader>
        <CardTitle>{item.name}</CardTitle>
        <CardDescription>{item.description}</CardDescription>
      </CardHeader>
      <CardContent>
        <div>
          <div>
            <img
              className="w-64 h-64 object-contain rounded-lg"
              src={item.image}
              alt={item.name}
            />
          </div>
          <div>
            <p className="text-sky-950 font-bold text-xl mt-5">${item.price}</p>
          </div>
        </div>
      </CardContent>
      <CardFooter className="flex justify-between gap-4">
        {cart.some((cartItem) => cartItem.id === item.id) ? (
          <Button
            className="flex-1"
            onClick={() => removeItem(item.id)}
            variant="destructive"
          >
            Remove from Cart
          </Button>
        ) : (
          <Button
            className="flex-1"
            onClick={() => addItem(createCartItem({ ...item }))}
          >
            Add to Cart
          </Button>
        )}
        <Button variant="link" className="text-sky-950" asChild>
          <Link to={`/${type}/${item.id}`}>Details</Link>
        </Button>
      </CardFooter>
    </Card>
  );
};

export default ShopItem;
