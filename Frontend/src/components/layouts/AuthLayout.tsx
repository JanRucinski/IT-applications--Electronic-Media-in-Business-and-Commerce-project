import { Link, Outlet } from 'react-router-dom';
import { ChevronLeft } from 'lucide-react';

import { Button } from '../ui/button';
import Footer from './Footer';

// TODO: Add protection form auth users
const AuthLayout = () => {
  return (
    <div className="flex flex-col min-h-screen">
      <div className="container pt-10">
        <Button asChild variant="ghost" size="lg">
          <Link to="/">
            <ChevronLeft /> Back
          </Link>
        </Button>
      </div>
      <section className="flex flex-1 justify-center items-center py-5">
        <Outlet />
      </section>
      <Footer />
    </div>
  );
};

export default AuthLayout;
