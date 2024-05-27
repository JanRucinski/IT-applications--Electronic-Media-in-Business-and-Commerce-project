import { PropsWithChildren, useState } from 'react';

import { Dialog, DialogTrigger } from '../ui/dialog';
import { mockedRentals } from '@/config/mock';
import RentDialog from './RentDialog';

type RentActionProps = PropsWithChildren & {
  bikeId: string;
};

const RentAction = ({ bikeId, children }: RentActionProps) => {
  const [open, setOpen] = useState(false);

  const bike = mockedRentals.find((rental) => rental.id === bikeId);

  if (!bike) {
    return null;
  }

  return (
    <Dialog open={open} onOpenChange={setOpen}>
      <DialogTrigger asChild>{children}</DialogTrigger>
      <RentDialog bike={bike} />
    </Dialog>
  );
};

export default RentAction;
