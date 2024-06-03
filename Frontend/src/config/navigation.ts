import { NavItem } from '@/types/config';

export const headerItems: NavItem[] = [
  {
    title: 'Bikes',
    to: '/bikes',
  },
  {
    title: 'Rental',
    to: '/rental',
  },
  {
    title: 'Parts',
    to: '/parts',
  },
  {
    title: 'About us',
    to: '/about',
  },
  {
    title: 'Contact',
    to: '/contact',
  },
];

export const adminHeaderItems: NavItem[] = [
  {
    title: 'Bikes',
    to: '/dashboard/bikes',
  },

  {
    title: 'Parts',
    to: '/dashboard/parts',
  },
  {
    title: 'Rentals',
    to: '/dashboard/rentals',
  },
  {
    title: 'Orders',
    to: '/dashboard/orders',
  },
];
