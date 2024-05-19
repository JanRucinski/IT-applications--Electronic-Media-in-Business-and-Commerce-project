import { Link, useLocation } from 'react-router-dom';

import MainLogo from './MainLogo';
import AuthButtons from './AuthButtons';
import UserNav from './UserNav';
import { headerItems } from '@/config/navigation';
import { Button } from '../ui/button';
import { cn } from '@/lib/utils';
import Cart from '../cart/Cart';

const Header = () => {
  // TODO: Implement authentication
  const isAuthenticated = false;
  const { pathname } = useLocation();

  return (
    <header className="sticky top-0 z-40 border-b bg-background">
      <div className="container flex h-16 items-center justify-between py-9">
        <MainLogo />
        <nav>
          <ul className="flex space-x-6">
            {headerItems.map((item) => (
              <li key={item.title}>
                <Button
                  asChild
                  variant="nav"
                  size="link"
                  className={cn(
                    'text-base',
                    pathname === item.to && 'text-primary'
                  )}
                >
                  <Link to={item.to}>{item.title}</Link>
                </Button>
              </li>
            ))}
          </ul>
        </nav>
        <nav className="flex items-center justify-center">
          <Cart />
          {isAuthenticated ? (
            <UserNav
              name="Murad"
              surname="Shahbazov"
              email="shahbazov.msh@gmail.com"
            />
          ) : (
            <AuthButtons />
          )}
        </nav>
      </div>
    </header>
  );
};

export default Header;
