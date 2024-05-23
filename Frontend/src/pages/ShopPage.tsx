import Filter from '@/components/shared/Filter';
import SearchBar from '@/components/shared/SearchBar';
import Sort from '@/components/shared/Sort';
import ShopItem from '@/components/shop/ShopItem';
import ShopPagination from '@/components/shop/ShopPagination';
import { bikeTypes } from '@/config/filter-options';
import { mockedBikes } from '@/config/mock';
import { maxItemsPerPage } from '@/constants/pagination';

const ShopPage = () => {
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
      <div className="grid md:grid-cols-4 md:gap-10 my-4">
        {mockedBikes.map((item) => (
          <ShopItem key={item.id} item={item} itemCategory="shop" />
        ))}
      </div>
      {mockedBikes.length > maxItemsPerPage && (
        <ShopPagination className="mt-16" />
      )}
    </section>
  );
};

export default ShopPage;
