import { ListFilter, X } from 'lucide-react';

import { Button } from '../ui/button';
import {
  DropdownMenu,
  DropdownMenuCheckboxItem,
  DropdownMenuContent,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from '../ui/dropdown-menu';
import { useSearchParams } from 'react-router-dom';
import { isMobile } from 'react-device-detect';
import { cn } from '@/lib/utils';
import { Category } from '@/constants/categories';

type FilterProps = {
  filterOptions: Category[];
  buttonStyle?: string;
  query: string;
};

const Filter = ({ buttonStyle, filterOptions, query }: FilterProps) => {
  const [searchParams, setSearchParams] = useSearchParams();
  const filter = searchParams.get(query);

  const selectFilter = (value: string) => {
    setSearchParams((params) => {
      params.set(query, value);
      return params;
    });
  };

  const clearFilter = () => {
    setSearchParams((params) => {
      params.delete(query);
      return params;
    });
  };

  return (
    <>
      <DropdownMenu>
        <DropdownMenuTrigger asChild className={buttonStyle}>
          <Button variant="outline" size="lg" className="h-10 gap-1">
            <ListFilter className="h-3.5 w-3.5" />
            <span className="sr-only sm:not-sr-only sm:whitespace-nowrap">
              {filter ? filter.split(' ')[0] : 'Filter'}
            </span>
          </Button>
        </DropdownMenuTrigger>
        <DropdownMenuContent align="end">
          <DropdownMenuLabel>Filter by</DropdownMenuLabel>
          <DropdownMenuSeparator />
          {filterOptions.map((option) => (
            <DropdownMenuCheckboxItem
              key={option.id}
              onClick={selectFilter.bind(this, option.name)}
              checked={filter === option.name}
            >
              {option.name.split(' ')[0]}
            </DropdownMenuCheckboxItem>
          ))}
        </DropdownMenuContent>
      </DropdownMenu>
      {filter && (
        <Button
          onClick={clearFilter}
          variant="secondary"
          className={cn('ml-3 rounded-lg', isMobile && 'ml-1')}
        >
          <X size={18} className={cn('mr-2', isMobile && 'mr-0')} />
          {!isMobile && 'Reset filter'}
        </Button>
      )}
    </>
  );
};

export default Filter;
