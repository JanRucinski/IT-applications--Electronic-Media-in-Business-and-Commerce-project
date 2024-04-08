import { BrowserRouter, Routes, Route } from 'react-router-dom';

import { HomePage, Unauthorized, PageNotFound, LoginPage } from './pages';
import Layout from './components/layouts/Layout';
import AuthLayout from './components/layouts/AuthLayout';
import SignUpPage from './pages/SignUpPage';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route element={<Layout />}>
          <Route path="/" element={<HomePage />} />
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
