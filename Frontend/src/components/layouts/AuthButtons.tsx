import { Link } from 'react-router-dom';

import { Button } from '../ui/button';

const AuthButtons = () => {
  return (
    <div className="hidden md:block space-x-3">
      <Button asChild variant="ghost">
        <Link to="/login">Login</Link>
      </Button>
      <Button asChild>
        <Link to="/sign-up">Sign-up</Link>
      </Button>
    </div>
  );
};

export default AuthButtons;
