const NotFoundState = ({ message }: { message?: string }) => {
  const label = message || 'No results found for your search.';

  return (
    <div className="flex-1 flex justify-center items-center mt-32 md:mt-48">
      <h1 className="text-xl md:text-2xl text-center text-sky-950">{label}</h1>
    </div>
  );
};

export default NotFoundState;
