import RentItem from '@/components/rent/RentItem';
import { mockedRentals } from '@/config/mock';

const RentalPage = () => {
  return (
    <section className="container">
      <div className="mt-5 mb-10 flex justify-between">
        <div className="text-center mx-auto">
          <h2 className="text-3xl font-semibold">
            Rent a bike for your next adventure
          </h2>
          <p className="text-lg mt-2 text-muted-foreground">
            Choose from a variety of bikes to rent for your next trip.
          </p>
        </div>
      </div>
      <div className="grid md:grid-cols-4 md:gap-10 my-4">
        {mockedRentals.map((item) => (
          <RentItem key={item.id} {...item} />
        ))}
      </div>
    </section>
  );
};

export default RentalPage;
