import { LucideIcon } from 'lucide-react';

export type NavItem = {
  title: string;
  icon?: LucideIcon;
  to: string;
};

export type BreadcrumbItemType = {
  name: string;
  url: string;
};

export type ItemCategory = 'shop' | 'parts';
