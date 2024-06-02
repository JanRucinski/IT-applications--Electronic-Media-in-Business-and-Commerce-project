import useSWR from 'swr';

const ITEMS_URL = '/items';
const BIKES_URL = ITEMS_URL + '/bikes';
const PARTS_URL = ITEMS_URL + '/parts';
const RENT_ITEMS_URL = ITEMS_URL + '/rent-items';

export const useBikes = (searchQuery?: string) => {
  const { data, isLoading, error, mutate } = useSWR(
    searchQuery ? `${BIKES_URL}?name=${searchQuery}` : BIKES_URL
  );

  return { data, isLoading, error, mutate };
};

export const useParts = (searchQuery?: string) => {
  const { data, isLoading, error, mutate } = useSWR(
    searchQuery ? `${PARTS_URL}?name=${searchQuery}` : PARTS_URL
  );

  return { data, isLoading, error, mutate };
};

export const useItem = (id: string) => {
  const { data, isLoading, error, mutate } = useSWR(`${ITEMS_URL}/${id}`);

  return { data, isLoading, error, mutate };
};

export const useRentItems = () => {
  const { data, isLoading, error, mutate } = useSWR(RENT_ITEMS_URL);

  return { data, isLoading, error, mutate };
};
