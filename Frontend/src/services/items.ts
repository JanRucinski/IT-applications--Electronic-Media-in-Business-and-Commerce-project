import axiosInstance from '@/lib/axios-instance';
import { Item } from '@/models/item';

export const createItem = async (item: Partial<Item>) => {
  const response = await axiosInstance.post('/items', {
    ...item,
  });

  return response.data;
};

export const updateItem = async (item: Partial<Item>) => {
  const response = await axiosInstance.put(`/items/${item.id}`, {
    ...item,
  });
  return response.data;
};
