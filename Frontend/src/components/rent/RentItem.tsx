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

const RentItem = ({ id, name, desc, imageUrl, price }: Item) => {
  return (
    <Card className="flex flex-col justify-between">
      <CardHeader>
        <CardTitle>{name}</CardTitle>
        <CardDescription>{desc}</CardDescription>
      </CardHeader>
      <CardContent>
        <div>
          <div>
            <img
              className="w-64 h-64 object-contain rounded-lg"
              src={imageUrl}
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
        <RentAction bikeId={id}>
          <Button className="flex-1">Rent now</Button>
        </RentAction>
      </CardFooter>
    </Card>
  );
};

export default RentItem;
