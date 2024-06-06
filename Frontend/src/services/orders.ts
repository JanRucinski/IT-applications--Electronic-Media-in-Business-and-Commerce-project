import axiosInstance from '@/lib/axios-instance';
import { Order } from '@/models/order';

const ORDERS_URL = '/orders';

export const createOrder = async (order: Order) => {
  const response = await axiosInstance.post(ORDERS_URL, order);
  return response.data;
};

export const updateOrder = async (order: Order) => {
  const response = await axiosInstance.put(ORDERS_URL, order);
  return response.data;
};

export const cancelOrder = async (id: string) => {
  const response = await axiosInstance.delete(`${ORDERS_URL}/${id}`);
  return response.data;
};
