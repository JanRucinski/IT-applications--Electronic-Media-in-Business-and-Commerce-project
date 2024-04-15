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

const ShopItem = ({ id, name, description, price, image }: Item) => {
  return (
    <Card className="flex flex-col justify-between hover:cursor-pointer hover:scale-105 transition-transform">
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
        <Button className="flex-1">Add to Cart</Button>
        <Button variant="link" className="text-sky-950" asChild>
          <Link to={`/shop/${id}`}>Details</Link>
        </Button>
      </CardFooter>
    </Card>
  );
};

export default ShopItem;