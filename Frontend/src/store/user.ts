import { create } from 'zustand';
import { persist } from 'zustand/middleware';

import { User } from '@/models/user';

interface AuthState {
  user?: User;
  setUser: (user: User) => void;
  logoutUser: () => void;
}

export const useAuth = create<AuthState>()(
  persist(
    (set) => ({
      user: undefined,
      setUser: (user) => set({ user }),
      logoutUser: () => set({ user: undefined }),
    }),
    {
      name: 'auth',
    }
  )
);
