import Filter from '@/components/shared/Filter';
import SearchBar from '@/components/shared/SearchBar';
import Sort from '@/components/shared/Sort';
import BikesList from '@/components/shop/BikesList';
import { bikesCategories } from '@/constants/categories';

const BikesPage = () => {
  return (
    <section className="container">
      <div className="mt-5 mb-10 flex justify-between flex-col md:flex-row gap-6 md:gap-2 items-center">
        <div className="flex justify-center items-center">
          <SearchBar inputStyle="rounded-none rounded-l-lg" />
          <Filter
            filterOptions={bikesCategories}
            buttonStyle="rounded-none rounded-r-lg border-l-0"
            query="category"
          />
        </div>
        <div className="flex items-center gap-2">
          <span>Sort by:</span>
          <Sort />
        </div>
      </div>
      <BikesList />
    </section>
  );
};

export default BikesPage;
