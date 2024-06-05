import Filter from '@/components/shared/Filter';
import SearchBar from '@/components/shared/SearchBar';
import PartsList from '@/components/shop/PartsList';
import { partsCategories } from '@/config/categories';

const PartsPage = () => {
  return (
    <section className="container">
      <div className="mt-5 mb-10 flex justify-center items-center">
        <SearchBar inputStyle="rounded-none rounded-l-lg" />
        <Filter
          filterOptions={partsCategories}
          query="category"
          buttonStyle="rounded-none rounded-r-lg border-l-0"
        />
      </div>
      <PartsList />
    </section>
  );
};

export default PartsPage;
