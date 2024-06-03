import { zodResolver } from '@hookform/resolvers/zod';
import { useForm } from 'react-hook-form';

import { Input } from '@/components/ui/input';
import {
  Form,
  FormControl,
  FormField,
  FormItem,
  FormLabel,
  FormMessage,
} from '@/components/ui/form';
import { itemSchema, ItemSchemaType } from '@/lib/validation/item-schema';
import { DialogFooter, DialogTrigger } from '../../ui/dialog';
import { Button } from '../../ui/button';
import { Item } from '@/models/item';

type ItemFormProps = {
  item?: Item;
  onSubmit: (values: ItemSchemaType) => void;
};

export const ItemForm = ({ item, onSubmit }: ItemFormProps) => {
  const form = useForm<ItemSchemaType>({
    resolver: zodResolver(itemSchema),
    mode: 'onTouched',
    defaultValues: {
      name: item?.name || '',
      desc: item?.desc || '',
      price: item?.price || 0,
      imageUrl: item?.imageUrl || '',
      quantity: item?.quantity || 0,
    },
  });

  return (
    <Form {...form}>
      <form
        className="space-y-6"
        onSubmit={form.handleSubmit(onSubmit)}
        name="itemForm"
      >
        <div className="grid gap-4 py-4">
          <FormField
            control={form.control}
            name="name"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Name</FormLabel>
                <FormControl>
                  <Input {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="desc"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Description</FormLabel>
                <FormControl>
                  <Input {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="price"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Price</FormLabel>
                <FormControl>
                  <Input {...field} type="number" />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="imageUrl"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Image</FormLabel>
                <FormControl>
                  <Input {...field} type="url" />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="quantity"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Quantity</FormLabel>
                <FormControl>
                  <Input {...field} type="number" />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
        </div>
        <DialogFooter>
          <DialogTrigger asChild>
            <Button type="submit">
              {item ? 'Save changes' : 'Create item'}
            </Button>
          </DialogTrigger>
        </DialogFooter>
      </form>
    </Form>
  );
};
