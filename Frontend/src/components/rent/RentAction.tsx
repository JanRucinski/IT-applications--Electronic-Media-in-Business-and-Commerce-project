import { PropsWithChildren, useState } from 'react';

import { Dialog, DialogTrigger } from '../ui/dialog';
import RentDialog from './RentDialog';
import { Item } from '@/models/item';

type RentActionProps = PropsWithChildren & {
  bike: Item;
};

const RentAction = ({ bike, children }: RentActionProps) => {
  const [open, setOpen] = useState(false);

  return (
    <Dialog open={open} onOpenChange={setOpen}>
      <DialogTrigger asChild>{children}</DialogTrigger>
      <RentDialog bike={bike} />
    </Dialog>
  );
};

export default RentAction;
