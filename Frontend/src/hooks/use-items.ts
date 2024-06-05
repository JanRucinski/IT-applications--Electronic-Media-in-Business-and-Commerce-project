import { MAX_ITEMS_PER_PAGE } from '@/constants/pagination';
import useSWR from 'swr';

const ITEMS_URL = '/items';
const BIKES_URL = ITEMS_URL + '/bikes';
const PARTS_URL = ITEMS_URL + '/parts';
const RENT_ITEMS_URL = ITEMS_URL + '/rent-items';

export const useBikes = (page: number = 1, nameQuery?: string) => {
  const { data, isLoading, error, mutate } = useSWR(
    nameQuery
      ? `${BIKES_URL}?name=${nameQuery}`
      : `${BIKES_URL}?page=${page}&size=${MAX_ITEMS_PER_PAGE}`
  );

  return { data, isLoading, error, mutate };
};

export const useParts = (page: number = 1, nameQuery?: string) => {
  const { data, isLoading, error, mutate } = useSWR(
    nameQuery
      ? `${PARTS_URL}?name=${nameQuery}`
      : `${PARTS_URL}?page=${page}&size=${MAX_ITEMS_PER_PAGE}`
  );

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
