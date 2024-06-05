import { Search } from 'lucide-react';
import { Input } from '../ui/input';
import { cn } from '@/lib/utils';
import { useSearchParams } from 'react-router-dom';
import { useDebounce } from '@/hooks/use-debounce';
import React, { useState, useEffect } from 'react';

type SearchBarProps = {
  containerStyle?: string;
  inputStyle?: string;
};

const SearchBar = ({ containerStyle, inputStyle }: SearchBarProps) => {
  const [search, setSearch] = useSearchParams();
  const query = search.get('name');
  const [inputValue, setInputValue] = useState(query || '');
  const debouncedInputValue = useDebounce(inputValue.trim(), 300);

  useEffect(() => {
    if (debouncedInputValue) {
      search.set('name', debouncedInputValue);
      setSearch(search);
    } else {
      search.delete('name');
      setSearch(search);
    }
  }, [debouncedInputValue, setSearch, search]);

  const handleSearchChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setInputValue(e.target.value);
  };

  return (
    <div className={cn('relative flex-1 md:grow-0', containerStyle)}>
      <Search className="absolute left-2.5 top-2.5 h-5 w-5 text-muted-foreground" />
      <Input
        type="search"
        placeholder="Search..."
        value={inputValue}
        onChange={handleSearchChange}
        className={cn(
          'w-full md:text-base rounded-lg bg-background pl-8 md:w-[300px] lg:w-[600px]',
          inputStyle
        )}
      />
    </div>
  );
};

export default SearchBar;
