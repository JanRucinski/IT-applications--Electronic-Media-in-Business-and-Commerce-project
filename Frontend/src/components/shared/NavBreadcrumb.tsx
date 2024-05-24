import { Link } from 'react-router-dom';

import {
  Breadcrumb,
  BreadcrumbItem,
  BreadcrumbLink,
  BreadcrumbList,
  BreadcrumbPage,
  BreadcrumbSeparator,
} from '@/components/ui/breadcrumb';
import { BreadcrumbItemType } from '@/types/config';

type BreadcrumbProps = {
  breadcrumbs: BreadcrumbItemType[];
  currentPage: string;
  containerClasses: string;
};

export const NavBreadcrumb = ({
  breadcrumbs,
  currentPage,
  containerClasses,
}: BreadcrumbProps) => {
  return (
    <Breadcrumb className={containerClasses}>
      <BreadcrumbList className="text-xl">
        {breadcrumbs.map((breadcrumb) => (
          <BreadcrumbItem key={breadcrumb.url}>
            <BreadcrumbLink asChild>
              <Link to={breadcrumb.url}>{breadcrumb.name}</Link>
            </BreadcrumbLink>
          </BreadcrumbItem>
        ))}
        <BreadcrumbSeparator className="[&>svg]:size-5" />
        <BreadcrumbItem key={currentPage}>
          <BreadcrumbPage>{currentPage}</BreadcrumbPage>
        </BreadcrumbItem>
      </BreadcrumbList>
    </Breadcrumb>
  );
};
