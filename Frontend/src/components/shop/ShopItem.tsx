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
import { useCartStore } from '@/hooks/context/use-cart-store';

type ShopItemProps = {
  item: Item;
  type: 'shop' | 'parts';
};

const ShopItem = ({
  item: { id, description, image, maxQuantity, name, price },
  type,
}: ShopItemProps) => {
  const { addItem, removeItem, cart } = useCartStore();

  const addToCart = () => {
    addItem({
      id,
      name,
      price,
      quantity: 1,
      maxQuantity: maxQuantity ? maxQuantity : 1,
    });
  };

  const removeFromCart = () => {
    removeItem(id);
  };

  return (
    <Card className="flex flex-col justify-between">
      <CardHeader>
        <CardTitle>{name}</CardTitle>
        <CardDescription>{description}</CardDescription>
      </CardHeader>
      <CardContent>
        <div>
          <div>
            <img
              className="w-64 h-64 object-contain rounded-lg"
              src={image}
              alt={name}
            />
          </div>
          <div>
            <p className="text-sky-950 font-bold text-xl mt-5">${price}</p>
          </div>
        </div>
      </CardContent>
      <CardFooter className="flex justify-between gap-4">
        {cart.find((item) => item.id === id) ? (
          <Button
            className="flex-1"
            onClick={removeFromCart}
            variant="destructive"
          >
            Remove from Cart
          </Button>
        ) : (
          <Button className="flex-1" onClick={addToCart}>
            Add to Cart
          </Button>
        )}
        <Button variant="link" className="text-sky-950" asChild>
          <Link to={`/${type}/${id}`}>Details</Link>
        </Button>
      </CardFooter>
    </Card>
  );
};

export default ShopItem;
