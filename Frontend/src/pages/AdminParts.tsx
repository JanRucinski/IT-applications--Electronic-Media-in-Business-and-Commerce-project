import { CreateItem } from '@/components/dashboard/items/CreateItem';
import Filter from '@/components/shared/Filter';
import SearchBar from '@/components/shared/SearchBar';
import PartsList from '@/components/shop/PartsList';
import { partsCategories } from '@/constants/categories';

const AdminParts = () => {
  return (
    <section className="container">
      <div className="mt-5 mb-10 flex justify-between">
        <div className="flex justify-center items-center">
          <SearchBar inputStyle="rounded-none rounded-l-lg" />
          <Filter
            filterOptions={partsCategories}
            buttonStyle="rounded-none rounded-r-lg border-l-0"
            query="category"
          />
        </div>
        <CreateItem itemCategory="parts" label="Add a new bike part" />
      </div>
      <PartsList isAdmin />
    </section>
  );
};

export default AdminParts;
