import { useSearchParams } from 'react-router-dom';

import {
  Pagination,
  PaginationContent,
  PaginationItem,
  PaginationLink,
  PaginationNext,
  PaginationPrevious,
} from '../ui/pagination';

type PaginationProps = {
  className?: string;
  totalPages: number;
  currentPage: number;
};

const ItemsPagination = ({
  className,
  totalPages,
  currentPage,
}: PaginationProps) => {
  const [params] = useSearchParams();

  const createLink = (page: number) => {
    params.set('page', page.toString());
    return `?${params.toString()}`;
  };

  return (
    <Pagination className={className}>
      <PaginationContent>
        {currentPage > 1 && (
          <PaginationItem>
            <PaginationPrevious to={createLink(currentPage - 1)} />
          </PaginationItem>
        )}
        {[...Array(totalPages)].map((_, i) => (
          <PaginationItem key={i + 1}>
            <PaginationLink
              to={createLink(i + 1)}
              isActive={currentPage === i + 1}
              onClick={() => window.scrollTo(0, 0)}
            >
              {i + 1}
            </PaginationLink>
          </PaginationItem>
        ))}
        {currentPage < totalPages && (
          <PaginationItem>
            <PaginationNext to={createLink(currentPage + 1)} />
          </PaginationItem>
        )}
      </PaginationContent>
    </Pagination>
  );
};

export default ItemsPagination;
