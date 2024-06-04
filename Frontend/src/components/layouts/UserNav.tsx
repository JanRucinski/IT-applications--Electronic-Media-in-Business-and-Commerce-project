import { Link, useNavigate } from 'react-router-dom';
import { isMobile } from 'react-device-detect';

import { Avatar, AvatarFallback } from '../ui/avatar';
import { Button } from '../ui/button';
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from '../ui/dropdown-menu';
import { adminHeaderItems, authHeaderItems } from '@/config/navigation';

type UserProps = {
  name: string;
  surname: string;
  email: string;
  isAdmin?: boolean;
};

const getFirstLetters = (name: string, surname: string) => {
  return name[0].toUpperCase() + surname[0].toUpperCase();
};

const UserNav = ({ name, surname, email, isAdmin }: UserProps) => {
  const navigate = useNavigate();

  const navItems = isAdmin ? adminHeaderItems : authHeaderItems;

  const logoutHandler = async () => {
    navigate('/login', { replace: true });
  };

  return (
    <DropdownMenu>
      <DropdownMenuTrigger asChild>
        <Button variant="ghost" className="relative h-10 w-10 rounded-full">
          <Avatar className="h-9 w-9 text-primary">
            <AvatarFallback>{getFirstLetters(name, surname)}</AvatarFallback>
          </Avatar>
        </Button>
      </DropdownMenuTrigger>
      <DropdownMenuContent className="w-56" align="end" forceMount>
        <DropdownMenuLabel className="font-normal">
          <div className="flex flex-col space-y-2">
            <p className="text-sm font-medium leading-none">{`${name} ${surname}`}</p>
            <p className="text-xs leading-none text-muted-foreground">
              {email}
            </p>
          </div>
        </DropdownMenuLabel>
        {isMobile && (
          <>
            <DropdownMenuSeparator />
            {navItems.map((item) => (
              <DropdownMenuItem
                key={item.title}
                asChild
                className="hover:cursor-pointer"
              >
                <Link to={item.to}>{item.title}</Link>
              </DropdownMenuItem>
            ))}
          </>
        )}
        <DropdownMenuSeparator />
        <DropdownMenuItem
          className="hover:cursor-pointer"
          onClick={logoutHandler}
        >
          Log out
        </DropdownMenuItem>
      </DropdownMenuContent>
    </DropdownMenu>
  );
};

export default UserNav;
