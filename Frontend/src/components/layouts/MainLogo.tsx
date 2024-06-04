import { Link } from 'react-router-dom';
import { BikeIcon as Logo } from 'lucide-react';

const MainLogo = () => {
  return (
    <nav className="flex gap-6 md:gap-1">
      <Link to="/" className="items-center space-x-2 flex">
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
