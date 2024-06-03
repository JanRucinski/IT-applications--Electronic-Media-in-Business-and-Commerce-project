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
import { useState } from 'react';

type ItemFormProps = {
  item?: Item;
  onSubmit: (values: ItemSchemaType, file: File) => void;
};

export const ItemForm = ({ item, onSubmit }: ItemFormProps) => {
  const [file, setFile] = useState<File | null>(null);

  const form = useForm<ItemSchemaType>({
    resolver: zodResolver(itemSchema),
    mode: 'onTouched',
    defaultValues: {
      name: item?.name || '',
      description: item?.description || '',
      price: item?.price || 0,
      maxQuantity: item?.maxQuantity || 0,
    },
  });

  const submit = form.handleSubmit((values) => {
    if (!file) {
      return;
    }
    onSubmit(values, file);
  });

  return (
    <Form {...form}>
      <form className="space-y-6" onSubmit={submit} name="eventForm">
        <div className="grid gap-4 py-4">
          <FormField
            control={form.control}
            name="name"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Event Name</FormLabel>
                <FormControl>
                  <Input {...field} />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="description"
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
                <FormLabel>
                  Price <span className="text-sm">(USD)</span>
                </FormLabel>
                <FormControl>
                  <Input {...field} type="number" />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <FormField
            control={form.control}
            name="maxQuantity"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Maximum Quantity</FormLabel>
                <FormControl>
                  <Input {...field} type="number" />
                </FormControl>
                <FormMessage />
              </FormItem>
            )}
          />
          <div>
            <label>Image</label>
            <input
              type="file"
              onChange={(e) => {
                if (e.target.files) {
                  setFile(e.target.files[0]);
                }
              }}
            />
            {!file && <p>Image file is required</p>}
          </div>
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
