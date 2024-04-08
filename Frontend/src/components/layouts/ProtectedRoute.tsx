import { Navigate, Outlet, useLocation } from 'react-router-dom';

import { Role } from '@/types/roles';

const ProtectedRoute = ({ allowedRoles }: { allowedRoles: Role[] }) => {
  // todo : Add authentication
  // !TEMP
  const user = {
    role: 'admin' as Role,
  };
  const location = useLocation();

  if (!user) return <Navigate to="/login" state={{ from: location }} replace />;
  if (!allowedRoles.includes(user.role))
    return <Navigate to="/unauthorized" replace />;
  return <Outlet />;
};

export default ProtectedRoute;
