import { BrowserRouter, Routes, Route } from 'react-router-dom';

import {
  HomePage,
  Unauthorized,
  PageNotFound,
  LoginPage,
  SignUpPage,
  BikesPage,
  ContactPage,
  AboutPage,
  PartsPage,
  RentalPage,
  BikeDetails,
  PartDetails,
  AdminDashboard,
  AdminBikes,
  AdminParts,
  AdminRental,
} from './pages';
import Layout from './components/layouts/Layout';
import AuthLayout from './components/layouts/AuthLayout';
import ProtectedRoute from './components/layouts/ProtectedRoute';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Layout />}>
          <Route index element={<HomePage />} />
          <Route path="/bikes" element={<BikesPage />} />
          <Route path="/bikes/:id" element={<BikeDetails />} />
          <Route path="/parts" element={<PartsPage />} />
          <Route path="/parts/:id" element={<PartDetails />} />
          <Route path="/rental" element={<RentalPage />} />
          <Route path="/contact" element={<ContactPage />} />
          <Route path="/about" element={<AboutPage />} />
          <Route element={<ProtectedRoute allowedRoles={['user']} />}>
            <Route path="/orders" element={<div>Users Orders</div>} />
            <Route path="/rentals" element={<div>Users Rentals</div>} />
          </Route>
        </Route>

        <Route element={<ProtectedRoute allowedRoles={['admin']} />}>
          <Route path="/dashboard" element={<Layout isAdmin />}>
            <Route index element={<AdminDashboard />} />
            <Route path="bikes" element={<AdminBikes />} />
            <Route path="parts" element={<AdminParts />} />
            <Route path="rental" element={<AdminRental />} />
            <Route path="rentals" element={<div>Rentals</div>} />
            <Route path="orders" element={<div>Orders</div>} />
          </Route>
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
