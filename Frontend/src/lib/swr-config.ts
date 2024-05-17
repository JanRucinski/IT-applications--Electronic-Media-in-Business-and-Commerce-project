import { SWRConfiguration } from 'swr';

import axiosInstance from '@/lib/axios-instance';

export const swrConfig: SWRConfiguration = {
  fetcher: (url: string) => axiosInstance.get(url).then((res) => res.data),
};
