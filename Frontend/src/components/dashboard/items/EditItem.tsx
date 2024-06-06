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
import { updateItem } from '@/services/items';
import { ItemCategory } from '@/types/config';
import { ItemSchemaType } from '@/schemas/item-schema';
import { useRefreshItems } from '@/hooks/use-items';

type EditItemProps = {
  item: Item;
  itemCategory: ItemCategory;
  buttonStyles?: string;
};

export const EditItem = ({ item, itemCategory }: EditItemProps) => {
  const { refresh } = useRefreshItems();

  const handleEdit = async (data: ItemSchemaType) => {
    try {
      await updateItem({
        ...data,
        id: item.id,
      });
      refresh();
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
        <ItemForm
          categoryName={itemCategory}
          item={item}
          onSubmit={handleEdit}
        />
      </DialogContent>
    </Dialog>
  );
};
