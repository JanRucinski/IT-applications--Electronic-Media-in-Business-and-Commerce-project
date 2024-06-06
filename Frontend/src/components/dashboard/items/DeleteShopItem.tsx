import { toast } from 'sonner';
import { PropsWithChildren } from 'react';

import {
  AlertDialog,
  AlertDialogAction,
  AlertDialogCancel,
  AlertDialogContent,
  AlertDialogDescription,
  AlertDialogFooter,
  AlertDialogHeader,
  AlertDialogTitle,
  AlertDialogTrigger,
} from '@/components/ui/alert-dialog';
import { Button } from '@/components/ui/button';
import axiosInstance from '@/lib/axios-instance';
import { useRefreshItems } from '@/hooks/use-items';
import { ItemCategory } from '@/types/config';

type DeleteShopItemProps = {
  itemId: string;
  itemCategory: ItemCategory;
  buttonStyles?: string;
} & PropsWithChildren;

export const DeleteShopItem = ({
  itemId,
  children,
  buttonStyles,
}: DeleteShopItemProps) => {
  const { refresh } = useRefreshItems();

  const handleDelete = async () => {
    try {
      await axiosInstance.delete(`/items/${itemId}`);
      refresh();
      toast.success('Item deleted successfully');
    } catch (error) {
      toast.error('Failed to delete item');
    }
  };

  return (
    <AlertDialog>
      <AlertDialogTrigger asChild>
        <Button variant="outline" className={buttonStyles}>
          {children}
        </Button>
      </AlertDialogTrigger>
      <AlertDialogContent>
        <AlertDialogHeader>
          <AlertDialogTitle>
            Are you sure you want to delete this item?
          </AlertDialogTitle>
          <AlertDialogDescription>
            This action cannot be undone.
          </AlertDialogDescription>
        </AlertDialogHeader>
        <AlertDialogFooter>
          <AlertDialogCancel>Cancel</AlertDialogCancel>
          <AlertDialogAction onClick={handleDelete}>Continue</AlertDialogAction>
        </AlertDialogFooter>
      </AlertDialogContent>
    </AlertDialog>
  );
};
