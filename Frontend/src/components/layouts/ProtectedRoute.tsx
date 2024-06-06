import { Navigate, Outlet, useLocation } from 'react-router-dom';

import { Role } from '@/types/roles';
import { useAuth } from '@/store/user';

const ProtectedRoute = ({ allowedRoles }: { allowedRoles: Role[] }) => {
  const location = useLocation();
  const { user } = useAuth();

  if (!user) return <Navigate to="/login" state={{ from: location }} replace />;
  if (!allowedRoles.includes(user.role))
    return <Navigate to="/unauthorized" replace />;
  return <Outlet />;
};

export default ProtectedRoute;
