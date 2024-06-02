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
import { useParts } from '@/hooks/use-parts';
import { useBikes } from '@/hooks/use-bikes';
import { ItemCategory } from '@/types/config';
import { ItemSchemaType } from '@/lib/validation/item-schema';
import { createItem } from '@/services/items';

type CreateItemProps = {
  itemCategory: ItemCategory;
};

export const CreateItem = ({ itemCategory }: CreateItemProps) => {
  const { mutate: refetchBikes } = useBikes();
  const { mutate: refetchParts } = useParts();

  const onRefresh = itemCategory === 'parts' ? refetchParts : refetchBikes;

  const handleCreateItem = async (data: ItemSchemaType, file: File) => {
    try {
      await createItem(data, file);
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
          Create Item
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
