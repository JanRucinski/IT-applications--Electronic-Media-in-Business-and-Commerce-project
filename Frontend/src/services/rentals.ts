import axiosInstance from '@/lib/axios-instance';
import { Rental } from '@/models/rental';

const RENTALS_URL = '/rentals';

export const rentItem = async (rental: Rental) => {
  const response = await axiosInstance.post(RENTALS_URL, rental);
  return response.data;
};

export const updateRent = async () => {
  const response = await axiosInstance.put(RENTALS_URL);
  return response.data;
};

export const cancelRental = async (id: string) => {
  const response = await axiosInstance.delete(`${RENTALS_URL}/${id}`);
  return response.data;
};
