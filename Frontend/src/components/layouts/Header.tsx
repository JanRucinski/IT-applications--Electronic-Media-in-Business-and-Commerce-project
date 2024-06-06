import { Link, useLocation } from 'react-router-dom';

import MainLogo from './MainLogo';
import AuthButtons from './AuthButtons';
import UserNav from './UserNav';
import { headerItems, adminHeaderItems } from '@/config/navigation';
import { Button } from '../ui/button';
import { cn } from '@/lib/utils';
import Cart from '../cart/Cart';
import MobileNav from './MobileNav';
import { useAuth } from '@/store/user';

type HeaderProps = {
  isAdmin?: boolean;
};

const Header = ({ isAdmin }: HeaderProps) => {
  const { user } = useAuth();
  const { pathname } = useLocation();

  const isAuthenticated = user?.token ? true : false;
  const navItems = isAdmin ? adminHeaderItems : headerItems;

  return (
    <header className="sticky top-0 z-40 border-b bg-background">
      <div className="container flex h-14 md:h-16 items-center justify-between py-2 md:py-9">
        <MainLogo />
        <nav className="hidden md:block">
          <ul className="flex space-x-8">
            {navItems.map((item) => (
              <li key={item.title}>
                <Button
                  asChild
                  variant="nav"
                  size="link"
                  className={cn(
                    'text-base',
                    pathname.includes(item.to) && 'text-primary'
                  )}
                >
                  <Link to={item.to}>{item.title}</Link>
                </Button>
              </li>
            ))}
          </ul>
        </nav>
        <nav className="flex items-center justify-center">
          {!isAdmin ? <Cart /> : null}
          {isAuthenticated ? (
            <UserNav
              fullName="Mushfig Shahbazov"
              email="shahbazov.msh@gmail.com"
            />
          ) : (
            <AuthButtons />
          )}
          {!isAuthenticated && <MobileNav />}
        </nav>
      </div>
    </header>
  );
};

export default Header;
