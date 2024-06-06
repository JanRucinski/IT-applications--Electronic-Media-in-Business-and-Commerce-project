import { Link, Outlet } from 'react-router-dom';
import { ChevronLeft } from 'lucide-react';
import { Toaster } from 'sonner';

import { Button } from '../ui/button';
import Footer from './Footer';

const AuthLayout = () => {
  return (
    <div className="flex flex-col min-h-screen">
      <div className="md:container pt-10 px-4">
        <Button asChild variant="ghost" size="lg" className="px-2 md:px-8">
          <Link to="/">
            <ChevronLeft /> Back
          </Link>
        </Button>
      </div>
      <section className="flex flex-1 justify-center items-center py-4 px-4">
        <Outlet />
      </section>
      <Toaster richColors offset={30} />
      <Footer />
    </div>
  );
};

export default AuthLayout;
