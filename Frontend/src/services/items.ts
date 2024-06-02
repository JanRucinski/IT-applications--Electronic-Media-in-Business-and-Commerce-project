import axiosInstance from '@/lib/axios-instance';
import { Item } from '@/models/item';

export const createItem = async (item: Partial<Item>, file: File) => {
  const itemDTOString = JSON.stringify(item);
  const formData = new FormData();

  formData.append('itemDTO', itemDTOString);
  formData.append('image', file);

  const response = await axiosInstance.post('/items', formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  });
  return response.data;
};

export const updateItem = async (item: Partial<Item>, file: File) => {
  const itemDTOString = JSON.stringify(item);
  const formData = new FormData();

  formData.append('itemDTO', itemDTOString);
  formData.append('image', file);

  const response = await axiosInstance.put(`/items/${item.id}`, formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  });
  return response.data;
};
