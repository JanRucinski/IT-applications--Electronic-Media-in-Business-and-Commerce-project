import { CreateItem } from '@/components/dashboard/items/CreateItem';
import Filter from '@/components/shared/Filter';
import SearchBar from '@/components/shared/SearchBar';
import ShopItem from '@/components/shop/ShopItem';
import { bikeTypes } from '@/config/filter-options';
import { mockedBikes } from '@/config/mock';

const AdminBikes = () => {
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

        <CreateItem itemCategory="bikes" />
      </div>
      <div className="grid md:grid-cols-4 md:gap-10 my-4">
        {mockedBikes.map((item) => (
          <ShopItem key={item.id} item={item} itemCategory="bikes" isAdmin />
        ))}
      </div>
    </section>
  );
};

export default AdminBikes;
