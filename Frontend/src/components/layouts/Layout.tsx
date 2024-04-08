import { Outlet } from 'react-router-dom';
import { Toaster } from 'sonner';

import Header from './Header';
import Footer from './Footer';

const Layout = () => {
  return (
    <div className="flex min-h-screen flex-col space-y-6">
      <Header />
      <main className="flex w-full flex-1 flex-col overflow-hidden">
        <Outlet />
      </main>
      <Toaster richColors offset={30} />
      <Footer />
    </div>
  );
};

export default Layout;
