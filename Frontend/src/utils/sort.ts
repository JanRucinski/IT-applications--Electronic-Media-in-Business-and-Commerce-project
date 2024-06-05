import { SortEnum } from '@/constants/sorting-filters';
import { Item } from '@/models/item';

type SortFunction = (items: Item[], order: 'asc' | 'desc') => Item[];

export const sortByPrice = (items: Item[], order: 'asc' | 'desc'): Item[] => {
  return [...items].sort((a, b) =>
    order === 'asc' ? a.price - b.price : b.price - a.price
  );
};

export const sortByName = (items: Item[], order: 'asc' | 'desc'): Item[] => {
  return [...items].sort((a, b) =>
    order === 'asc'
      ? a.name.localeCompare(b.name)
      : b.name.localeCompare(a.name)
  );
};

export const sortByRelevance = (items: Item[]): Item[] => {
  return items;
};

const sortFunctions: Partial<Record<SortEnum, SortFunction>> = {
  [SortEnum.PriceAsc]: sortByPrice,
  [SortEnum.PriceDesc]: sortByPrice,
  [SortEnum.Name]: sortByName,
  [SortEnum.Relevance]: sortByRelevance,
};

const sortOrders: Partial<Record<SortEnum, 'asc' | 'desc'>> = {
  [SortEnum.PriceAsc]: 'asc',
  [SortEnum.PriceDesc]: 'desc',
  [SortEnum.Name]: 'asc',
  [SortEnum.Relevance]: undefined,
};

export const getSortedItems = (items: Item[], sort: SortEnum): Item[] => {
  const sortFunction = sortFunctions[sort];
  const sortOrder = sortOrders[sort];
  return sortFunction && sortOrder ? sortFunction(items, sortOrder) : items;
};
