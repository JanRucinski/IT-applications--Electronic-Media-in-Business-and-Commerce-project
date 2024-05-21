import { Link } from 'react-router-dom';

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

const RentItem = ({ id, name, description, image, price }: Item) => {
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
            <p className="text-sky-950 font-bold text-xl mt-5">
              ${price} / day
            </p>
          </div>
        </div>
      </CardContent>
      <CardFooter>
        <Button className="flex-1" asChild>
          <Link to={`/rental/${id}`}>Rent now</Link>
        </Button>
      </CardFooter>
    </Card>
  );
};

export default RentItem;
