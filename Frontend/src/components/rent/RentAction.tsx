import { PropsWithChildren, useState } from 'react';

import { Dialog, DialogTrigger } from '../ui/dialog';
import RentDialog from './RentDialog';
import { useItem } from '@/hooks/use-items';

type RentActionProps = PropsWithChildren & {
  bikeId: string;
};

const RentAction = ({ bikeId, children }: RentActionProps) => {
  const [open, setOpen] = useState(false);

  const { data, error, isLoading } = useItem(bikeId);

  if (!data || error || isLoading) {
    return null;
  }

  return (
    <Dialog open={open} onOpenChange={setOpen}>
      <DialogTrigger asChild>{children}</DialogTrigger>
      <RentDialog bike={data} />
    </Dialog>
  );
};

export default RentAction;
