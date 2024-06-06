import { CreateItem } from '@/components/dashboard/items/CreateItem';
import Filter from '@/components/shared/Filter';
import SearchBar from '@/components/shared/SearchBar';
import BikesList from '@/components/shop/BikesList';
import { bikesCategories } from '@/constants/categories';

const AdminBikes = () => {
  return (
    <section className="container">
      <div className="mt-5 mb-10 flex justify-between">
        <div className="flex justify-center items-center">
          <SearchBar inputStyle="rounded-none rounded-l-lg" />
          <Filter
            query="category"
            filterOptions={bikesCategories}
            buttonStyle="rounded-none rounded-r-lg border-l-0"
          />
        </div>
        <CreateItem itemCategory="bikes" label="Add a new bike" />
      </div>
      <BikesList isAdmin />
    </section>
  );
};

export default AdminBikes;
