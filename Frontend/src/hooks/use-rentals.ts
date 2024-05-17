import swr from 'swr';

const RENTALS_URL = '/orders';

export const useRentals = () => {
  const { data, isLoading, error, mutate } = swr(RENTALS_URL);

  return { data, isLoading, error, mutate };
};
