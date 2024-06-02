import { toast } from 'sonner';

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
import { Item } from '@/models/item';
import { ItemSchemaType } from '@/lib/validation/item-schema';
import { updateItem } from '@/services/items';
import { useBikes, useParts } from '@/hooks/use-items';
import { ItemCategory } from '@/types/config';

type EditItemProps = {
  item: Item;
  itemCategory: ItemCategory;
  buttonStyles?: string;
};

export const EditItem = ({ item, itemCategory }: EditItemProps) => {
  const { mutate: refetchBikes } = useBikes();
  const { mutate: refetchParts } = useParts();

  const onRefresh = itemCategory === 'parts' ? refetchParts : refetchBikes;

  const handleEdit = async (data: ItemSchemaType, file: File) => {
    try {
      await updateItem(data, file);
      onRefresh();
      toast.success('Item updated successfully');
    } catch (error) {
      toast.error('Failed to update item');
    }
  };

  return (
    <Dialog>
      <DialogTrigger asChild>
        <Button variant="default" className="flex-1">
          Edit Item
        </Button>
      </DialogTrigger>
      <DialogContent className="md:w-[900px]">
        <DialogHeader>
          <DialogTitle>Edit Item</DialogTitle>
          <DialogDescription>Make changes to the item.</DialogDescription>
        </DialogHeader>
        <ItemForm item={item} onSubmit={handleEdit} />
      </DialogContent>
    </Dialog>
  );
};
