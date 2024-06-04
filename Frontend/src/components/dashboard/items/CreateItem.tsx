import { toast } from 'sonner';
import { Plus } from 'lucide-react';

import { Button } from '@/components/ui/button';
import {
  Dialog,
  DialogContent,
  DialogDescription,
  DialogHeader,
  DialogTitle,
  DialogTrigger,
} from '@/components/ui/dialog';
import { ItemForm } from './ItemForm';
import { useBikes, useParts } from '@/hooks/use-items';
import { ItemCategory } from '@/types/config';
import { createItem } from '@/services/items';
import { ItemSchemaType } from '@/schemas/item-schema';

type CreateItemProps = {
  itemCategory: ItemCategory;
  label?: string;
};

export const CreateItem = ({ itemCategory, label }: CreateItemProps) => {
  const { mutate: refetchBikes } = useBikes();
  const { mutate: refetchParts } = useParts();

  const onRefresh = itemCategory === 'parts' ? refetchParts : refetchBikes;

  const handleCreateItem = async (data: ItemSchemaType) => {
    try {
      await createItem(data);
      onRefresh();
      toast.success('Item added successfully');
    } catch (error) {
      toast.error('Failed to add item');
    }
  };

  return (
    <Dialog>
      <DialogTrigger asChild>
        <Button size="lg">
          <Plus size={16} strokeWidth={2} className="mr-2" />
          {label || 'Add a new item'}
        </Button>
      </DialogTrigger>
      <DialogContent className="md:w-[900px]">
        <DialogHeader>
          <DialogTitle>Create new Item</DialogTitle>
          <DialogDescription>
            Fill in the details of the item to add.
          </DialogDescription>
        </DialogHeader>
        <ItemForm onSubmit={handleCreateItem} />
      </DialogContent>
    </Dialog>
  );
};
