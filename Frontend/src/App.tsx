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
  OrderCheckoutPage,
  RentalCheckoutPage,
  OrdersPage,
  RentsPage,
  AdminRentals,
  AdminOrders,
} from './pages';
import Layout from './components/layouts/Layout';
import ProtectedRoute from './components/layouts/ProtectedRoute';
import LayoutWithoutHeader from './components/layouts/LayoutWithoutHeader';

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
            <Route path="/orders" element={<OrdersPage />} />
            <Route path="/rentals" element={<RentsPage />} />
          </Route>
        </Route>

        <Route element={<ProtectedRoute allowedRoles={['admin']} />}>
          <Route path="/dashboard" element={<Layout isAdmin />}>
            <Route index element={<AdminDashboard />} />
            <Route path="bikes" element={<AdminBikes />} />
            <Route path="parts" element={<AdminParts />} />
            <Route path="rental" element={<AdminRental />} />
            <Route path="rentals" element={<AdminRentals />} />
            <Route path="orders" element={<AdminOrders />} />
          </Route>
        </Route>

        <Route element={<LayoutWithoutHeader />}>
          <Route path="/login" element={<LoginPage />} />
          <Route path="/sign-up" element={<SignUpPage />} />
          <Route path="/checkout/order" element={<OrderCheckoutPage />} />
          <Route path="/checkout/rental" element={<RentalCheckoutPage />} />
        </Route>

        <Route path="/unauthorized" element={<Unauthorized />} />
        <Route path="*" element={<PageNotFound />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
