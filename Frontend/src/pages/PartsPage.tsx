import Filter from '@/components/shared/Filter';
import SearchBar from '@/components/shared/SearchBar';
import ShopItem from '@/components/shop/ShopItem';
import ShopPagination from '@/components/shop/ShopPagination';
import { bikeParts } from '@/config/filter-options';
import { mockedBikeParts } from '@/config/mock';
import { maxItemsPerPage } from '@/constants/pagination';

const PartsPage = () => {
  return (
    <section className="container">
      <div className="mt-5 mb-10 flex justify-center items-center">
        <SearchBar inputStyle="rounded-none rounded-l-lg" />
        <Filter
          filterOptions={bikeParts}
          buttonStyle="rounded-none rounded-r-lg border-l-0"
        />
      </div>
      <div className="grid md:grid-cols-4 md:gap-10 my-4">
        {mockedBikeParts.map((item) => (
          <ShopItem key={item.id} item={item} type="parts" />
        ))}
      </div>
      {mockedBikeParts.length > maxItemsPerPage && (
        <ShopPagination className="mt-16" />
      )}
    </section>
  );
};

export default PartsPage;
