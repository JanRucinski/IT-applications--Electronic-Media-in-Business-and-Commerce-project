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
import { useAuth } from '@/store/user';

type UserProps = {
  fullName: string;
  email: string;
  isAdmin?: boolean;
};

const getFirstLetters = (fullName: string) => {
  const [name, surname] = fullName.split(' ');
  return name[0].toUpperCase() + surname[0].toUpperCase();
};

const UserNav = ({ fullName, email, isAdmin }: UserProps) => {
  const { logoutUser } = useAuth();
  const navigate = useNavigate();

  const navItems = isAdmin ? adminHeaderItems : authHeaderItems;

  const logoutHandler = async () => {
    logoutUser();
    navigate('/', { replace: true });
  };

  return (
    <DropdownMenu>
      <DropdownMenuTrigger asChild>
        <Button variant="ghost" className="relative h-10 w-10 rounded-full">
          <Avatar className="h-9 w-9 text-primary">
            <AvatarFallback>{getFirstLetters(fullName)}</AvatarFallback>
          </Avatar>
        </Button>
      </DropdownMenuTrigger>
      <DropdownMenuContent className="w-56" align="end" forceMount>
        <DropdownMenuLabel className="font-normal">
          <div className="flex flex-col space-y-2">
            <p className="text-sm font-medium leading-none">{fullName}</p>
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
