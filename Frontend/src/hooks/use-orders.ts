import swr from 'swr';

const ORDERS_URL = '/orders';

export const useOrders = () => {
  const { data, isLoading, error, mutate } = swr(ORDERS_URL);

  return { data, isLoading, error, mutate };
};
