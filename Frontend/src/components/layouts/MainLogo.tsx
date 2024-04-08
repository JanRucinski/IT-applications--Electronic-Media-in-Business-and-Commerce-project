import { Link } from 'react-router-dom';
import { BikeIcon as Logo } from 'lucide-react';

const MainLogo = () => {
  return (
    <div className="flex gap-6 md:gap-1">
      <Link to="/" className="items-center space-x-2 md:flex">
        <Logo className="text-primary" size={32} strokeWidth={2.5} />
        <span className="font-semibold sm:inline-block text-primary text-2xl">
          BikeShop
        </span>
      </Link>
    </div>
  );
};

export default MainLogo;
