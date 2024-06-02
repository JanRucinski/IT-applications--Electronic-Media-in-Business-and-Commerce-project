import useSWR from 'swr';

const BIKES_URL = '/bikes';

export const useBikes = (searchQuery?: string) => {
  const { data, isLoading, error, mutate } = useSWR(
    searchQuery ? `${BIKES_URL}?type=${searchQuery}` : BIKES_URL
  );

  return { data, isLoading, error, mutate };
};

export const useBike = (id: string) => {
  const { data, isLoading, error, mutate } = useSWR(`${BIKES_URL}/${id}`);

  return { data, isLoading, error, mutate };
};
