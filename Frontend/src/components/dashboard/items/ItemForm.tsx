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
import { DialogFooter, DialogTrigger } from '../../ui/dialog';
import { Button } from '../../ui/button';
import { Item } from '@/models/item';
import { ItemSchemaType, itemSchema } from '@/schemas/item-schema';
import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '@/components/ui/select';
import { ItemCategory } from '@/types/config';
import {
  bikesCategories,
  partsCategories,
  rentalCategories,
} from '@/constants/categories';
import { useMemo } from 'react';

type ItemFormProps = {
  item?: Item;
  categoryName: ItemCategory;
  onSubmit: (values: ItemSchemaType) => void;
};

export const ItemForm = ({ item, onSubmit, categoryName }: ItemFormProps) => {
  const dict =
    categoryName === 'bikes'
      ? bikesCategories
      : categoryName === 'parts'
      ? partsCategories
      : rentalCategories;

  const category = useMemo(
    () => dict.find((c) => c.id === item?.categoryId),
    [dict, item?.categoryId]
  );

  const form = useForm<ItemSchemaType>({
    resolver: zodResolver(itemSchema),
    mode: 'onTouched',
    defaultValues: {
      name: item?.name || '',
      desc: item?.desc || '',
      price: item?.price || 0.0,
      imageUrl: item?.imageUrl || '',
      quantity: item?.quantity || 1,
      categoryId: category?.id || undefined,
    },
  });

  return (
    <Form {...form}>
      <form
        className="space-y-6"
        onSubmit={form.handleSubmit(onSubmit)}
        name="itemForm"
      >
        <div className="grid gap-4 py-2">
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
          <FormField
            control={form.control}
            name="categoryId"
            render={({ field }) => (
              <FormItem>
                <FormLabel>Category</FormLabel>
                <Select
                  onValueChange={field.onChange}
                  defaultValue={field?.value?.toString() || undefined}
                >
                  <FormControl>
                    <SelectTrigger>
                      <SelectValue placeholder="Select category" />
                    </SelectTrigger>
                  </FormControl>
                  <SelectContent>
                    {dict.map((c) => (
                      <SelectItem key={c.id} value={c.id.toString()}>
                        {c.name.split(' ')[0]}
                      </SelectItem>
                    ))}
                  </SelectContent>
                </Select>
              </FormItem>
            )}
          />
        </div>
        <DialogFooter>
          <DialogTrigger asChild>
            <Button type="submit" className="flex-1">
              {item ? 'Save changes' : 'Create item'}
            </Button>
          </DialogTrigger>
        </DialogFooter>
      </form>
    </Form>
  );
};
