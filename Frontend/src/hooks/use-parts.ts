import useSWR from 'swr';

const PARTS_URL = '/parts';

export const useParts = (searchQuery?: string) => {
  const { data, isLoading, error, mutate } = useSWR(
    searchQuery ? `${PARTS_URL}?type=${searchQuery}` : PARTS_URL
  );

  return { data, isLoading, error, mutate };
};

export const usePart = (id: string) => {
  const { data, isLoading, error, mutate } = useSWR(`${PARTS_URL}/${id}`);

  return { data, isLoading, error, mutate };
};
