import Filter from '@/components/shared/Filter';
import SearchBar from '@/components/shared/SearchBar';
import Sort from '@/components/shared/Sort';
import BikesList from '@/components/shop/BikesList';
import ShopPagination from '@/components/shop/ShopPagination';
import { bikeTypes } from '@/config/filter-options';
import { mockedBikes } from '@/config/mock';
import { maxItemsPerPage } from '@/constants/pagination';

const BikesPage = () => {
  return (
    <section className="container">
      <div className="mt-5 mb-10 flex justify-between">
        <div className="flex justify-center items-center">
          <SearchBar inputStyle="rounded-none rounded-l-lg" />
          <Filter
            filterOptions={bikeTypes}
            buttonStyle="rounded-none rounded-r-lg border-l-0"
          />
        </div>
        <div className="flex items-center gap-2">
          <span>Sort by:</span>
          <Sort setValue={(value) => console.log(value)} />
        </div>
      </div>
      <BikesList />
      {mockedBikes.length > maxItemsPerPage && (
        <ShopPagination className="mt-16" />
      )}
    </section>
  );
};

export default BikesPage;
