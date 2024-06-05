import { ArrowRightIcon } from 'lucide-react';
import { DateRange } from 'react-day-picker';
import { useState } from 'react';

import { Button } from '../ui/button';
import {
  DialogContent,
  DialogDescription,
  DialogFooter,
  DialogHeader,
  DialogTitle,
} from '../ui/dialog';
import { Item } from '@/models/item';
import { DateRangePicker } from './DateRangePicker';
import { calculateRentPrice } from '@/utils/helper';

type RentDialogProps = {
  onClose?: () => void;
  bike: Item;
};

const RentDialog = ({ bike }: RentDialogProps) => {
  const [date, setDate] = useState<DateRange | undefined>({
    from: undefined,
    to: undefined,
  });

  return (
    <DialogContent className="w-[90%] md:w-full sm:max-w-md min-w-min max-h-[92%] overflow-y-scroll rounded-lg">
      <DialogHeader>
        <DialogTitle className="text-xl md:text-2xl text-sky-950">
          Rent {bike.name}
        </DialogTitle>
        <DialogDescription>
          Choose the dates you want to rent this bike for.
        </DialogDescription>
      </DialogHeader>
      <div className="flex flex-col md:flex-row justify-between items-center shadow-md py-4 md:px-6 rounded-lg gap-4">
        <img
          src={bike.imageUrl}
          alt={bike.name}
          className="w-32 h-28 md:w-48 md:h-44 object-contain rounded-lg border p-1"
        />
        <div className="flex-1 md:mx-4 md:p-1 md:w-96">
          <h4 className="text-lg font-semibold text-sky-950">{bike.name}</h4>
          <p className="text-muted-foreground">
            ${bike.price.toFixed(2)} / day
          </p>
        </div>
      </div>
      <div className="flex flex-col md:flex-row justify-between items-center gap-4">
        <DateRangePicker date={date} setDate={setDate} />
        <span className="text-lg md:text-2xl px-2 md:px-6 text-sky-950">
          {calculateRentPrice(date, bike.price).toFixed(2)}$
        </span>
      </div>
      <DialogFooter>
        <Button className="flex-1" disabled={!date || !date.from || !date.to}>
          Checkout
          <ArrowRightIcon size={18} className="ml-2" />
        </Button>
      </DialogFooter>
    </DialogContent>
  );
};

export default RentDialog;
