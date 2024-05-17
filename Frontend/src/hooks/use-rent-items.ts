import useSWR from 'swr';

const RENT_ITEMS_URL = '/rent-items';

export const useRentItems = () => {
  const { data, isLoading, error, mutate } = useSWR(RENT_ITEMS_URL);

  return { data, isLoading, error, mutate };
};

export const useRentItem = (id: string) => {
  const { data, isLoading, error, mutate } = useSWR(`${RENT_ITEMS_URL}/${id}`);

  return { data, isLoading, error, mutate };
};
