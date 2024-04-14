import { ListFilter } from 'lucide-react';

import { Button } from '../ui/button';
import {
  DropdownMenu,
  DropdownMenuCheckboxItem,
  DropdownMenuContent,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from '../ui/dropdown-menu';

type FilterProps = {
  buttonStyle?: string;
};

const Filter = ({ buttonStyle }: FilterProps) => {
  return (
    <DropdownMenu>
      <DropdownMenuTrigger asChild className={buttonStyle}>
        <Button variant="outline" size="lg" className="h-10 gap-1">
          <ListFilter className="h-3.5 w-3.5" />
          <span className="sr-only sm:not-sr-only sm:whitespace-nowrap">
            Filter
          </span>
        </Button>
      </DropdownMenuTrigger>
      <DropdownMenuContent align="end">
        <DropdownMenuLabel>Filter by</DropdownMenuLabel>
        <DropdownMenuSeparator />
        <DropdownMenuCheckboxItem>Road</DropdownMenuCheckboxItem>
        <DropdownMenuCheckboxItem>Mountain</DropdownMenuCheckboxItem>
        <DropdownMenuCheckboxItem>BMX</DropdownMenuCheckboxItem>
      </DropdownMenuContent>
    </DropdownMenu>
  );
};

export default Filter;
