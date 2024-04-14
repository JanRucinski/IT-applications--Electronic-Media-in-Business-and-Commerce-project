import { Search } from 'lucide-react';

import { Input } from '../ui/input';
import { cn } from '@/lib/utils';

type SearchBarProps = {
  containerStyle?: string;
  inputStyle?: string;
};

const SearchBar = ({ containerStyle, inputStyle }: SearchBarProps) => {
  return (
    <div className={cn('relative flex-1 md:grow-0', containerStyle)}>
      <Search className="absolute left-2.5 top-2.5 h-5 w-5 text-muted-foreground" />
      <Input
        type="search"
        placeholder="Search..."
        className={cn(
          'w-full md:text-base rounded-lg bg-background pl-8 md:w-[300px] lg:w-[600px]',
          inputStyle
        )}
      />
    </div>
  );
};

export default SearchBar;
