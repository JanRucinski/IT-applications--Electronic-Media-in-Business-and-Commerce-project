import { Outlet } from 'react-router-dom';
import { Toaster } from 'sonner';
import { SWRConfig } from 'swr';

import Header from './Header';
import Footer from './Footer';
import { swrConfig } from '@/lib/swr-config';

const Layout = () => {
  return (
    <div className="flex min-h-screen flex-col space-y-6">
      <SWRConfig value={swrConfig}>
        <Header />
        <main className="flex w-full flex-1 flex-col overflow-hidden">
          <Outlet />
        </main>
        <Toaster richColors offset={30} />
        <Footer />
      </SWRConfig>
    </div>
  );
};

export default Layout;
