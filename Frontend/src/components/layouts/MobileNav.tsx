import { Link } from 'react-router-dom';
import { MenuIcon } from 'lucide-react';

import { Button } from '../ui/button';
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from '../ui/dropdown-menu';
import { headerItems } from '@/config/navigation';

const MobileNav = () => {
  return (
    <div className="md:hidden">
      <DropdownMenu>
        <DropdownMenuTrigger asChild>
          <Button variant="nav" size="icon">
            <MenuIcon size={20} />
          </Button>
        </DropdownMenuTrigger>
        <DropdownMenuContent className="w-56" align="end" forceMount>
          <DropdownMenuLabel className="font-normal">
            <div className="flex flex-col space-y-2">
              <p className="text-sm font-medium leading-none">Menu</p>
              <p className="text-xs leading-none text-muted-foreground">
                Choose a page
              </p>
            </div>
          </DropdownMenuLabel>
          <DropdownMenuSeparator />
          <DropdownMenuItem asChild className="hover:cursor-pointer">
            <Link to="/login">Login</Link>
          </DropdownMenuItem>
          <DropdownMenuItem asChild className="hover:cursor-pointer">
            <Link to="/sign-up">Sign-up</Link>
          </DropdownMenuItem>
          {headerItems.map((item) => (
            <DropdownMenuItem
              key={item.title}
              asChild
              className="hover:cursor-pointer"
            >
              <Link to={item.to}>{item.title}</Link>
            </DropdownMenuItem>
          ))}
        </DropdownMenuContent>
      </DropdownMenu>
    </div>
  );
};

export default MobileNav;
