import { MAX_ITEMS_PER_PAGE } from '@/constants/pagination';
import useSWR, { useSWRConfig } from 'swr';

const ITEMS_URL = '/items';
const BIKES_URL = ITEMS_URL + '/bikes';
const PARTS_URL = ITEMS_URL + '/parts';
const RENT_ITEMS_URL = ITEMS_URL + '/rent-items';

export const useBikes = (
  page: number = 1,
  nameQuery?: string,
  category?: string
) => {
  let url = `${BIKES_URL}?page=${page}&size=${MAX_ITEMS_PER_PAGE}`;

  if (nameQuery) {
    url += `&name=${nameQuery}`;
  }
  if (category !== undefined) {
    url += `&categoryNames=${category}`;
  }

  const { data, isLoading, error, mutate } = useSWR(url);

  return { data, isLoading, error, mutate };
};

export const useParts = (
  page: number = 1,
  nameQuery?: string,
  category?: string
) => {
  let url = `${PARTS_URL}?page=${page}&size=${MAX_ITEMS_PER_PAGE}`;

  if (nameQuery) {
    url += `&name=${nameQuery}`;
  }
  if (category !== undefined) {
    url += `&categoryNames=${category}`;
  }

  const { data, isLoading, error, mutate } = useSWR(url);

  return { data, isLoading, error, mutate };
};

export const useRentItems = (page: number = 1) => {
  const { data, isLoading, error, mutate } = useSWR(
    `${RENT_ITEMS_URL}?page=${page}&size=${MAX_ITEMS_PER_PAGE}`
  );

  return { data, isLoading, error, mutate };
};

export const useItem = (id: string) => {
  const { data, isLoading, error, mutate } = useSWR(`${ITEMS_URL}/${id}`);

  return { data, isLoading, error, mutate };
};

export const useRefreshItems = () => {
  const { mutate } = useSWRConfig();

  const refresh = () => {
    mutate(
      (key) => typeof key === 'string' && key.startsWith('/items'),
      undefined,
      { revalidate: true }
    );
  };

  return { refresh };
};
