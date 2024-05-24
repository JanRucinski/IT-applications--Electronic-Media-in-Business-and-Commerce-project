import { BrowserRouter, Routes, Route } from 'react-router-dom';

import {
  HomePage,
  Unauthorized,
  PageNotFound,
  LoginPage,
  SignUpPage,
  ShopPage,
  ContactPage,
  AboutPage,
  PartsPage,
  RentalPage,
  ShopItemDetails,
  PartDetails,
} from './pages';
import Layout from './components/layouts/Layout';
import AuthLayout from './components/layouts/AuthLayout';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Layout />}>
          <Route path="/" element={<HomePage />} />
          <Route path="/shop" element={<ShopPage />} />
          <Route path="/shop/:id" element={<ShopItemDetails />} />
          <Route path="/parts" element={<PartsPage />} />
          <Route path="/parts/:id" element={<PartDetails />} />
          <Route path="/rental" element={<RentalPage />} />
          <Route path="/contact" element={<ContactPage />} />
          <Route path="/about" element={<AboutPage />} />
        </Route>

        <Route element={<AuthLayout />}>
          <Route path="/login" element={<LoginPage />} />
          <Route path="/sign-up" element={<SignUpPage />} />
        </Route>

        <Route path="/unauthorized" element={<Unauthorized />} />
        <Route path="*" element={<PageNotFound />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
