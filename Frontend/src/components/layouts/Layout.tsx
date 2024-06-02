import { Outlet } from 'react-router-dom';
import { Toaster } from 'sonner';
import { SWRConfig } from 'swr';

import Header from './Header';
import Footer from './Footer';
import { swrConfig } from '@/lib/swr-config';

type LayoutProps = {
  isAdmin?: boolean;
};

const Layout = ({ isAdmin }: LayoutProps) => {
  return (
    <div className="flex min-h-screen flex-col space-y-6">
      <SWRConfig value={swrConfig}>
        <Header isAdmin={isAdmin} />
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
