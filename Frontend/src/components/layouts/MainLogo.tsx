import { Link } from 'react-router-dom';
import { BikeIcon as Logo } from 'lucide-react';
import { useAuth } from '@/store/user';

const MainLogo = () => {
  const { user } = useAuth();

  const link = user && user.role === 'admin' ? '/dashboard' : '/';
  return (
    <nav className="flex gap-6 md:gap-1">
      <Link to={link} className="items-center space-x-2 flex">
        <Logo
          className="text-primary w-6 h-6 md:w-8 md:h-8"
          strokeWidth={2.5}
        />
        <span className="font-semibold md:inline-block text-primary text-lg md:text-2xl">
          BikeShop
        </span>
      </Link>
    </nav>
  );
};

export default MainLogo;
