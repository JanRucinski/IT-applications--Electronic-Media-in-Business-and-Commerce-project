import { Link } from 'react-router-dom';

import MainLogo from './MainLogo';
import AuthButtons from './AuthButtons';
import UserNav from './UserNav';
import { headerItems } from '@/config/navigation';
import { Button } from '../ui/button';

const Header = () => {
  // TODO: Implement authentication
  const isAuthenticate = false;

  return (
    <header className="sticky top-0 z-40 border-b bg-background">
      <div className="container flex h-16 items-center justify-between py-9">
        <MainLogo />
        <nav>
          <ul className="flex space-x-4">
            {headerItems.map((item) => (
              <li key={item.title}>
                <Button
                  asChild
                  variant="link"
                  className="text-base text-sky-950"
                >
                  <Link to={item.to}>{item.title}</Link>
                </Button>
              </li>
            ))}
          </ul>
        </nav>
        <nav className="flex items-center justify-center">
          {isAuthenticate ? (
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
