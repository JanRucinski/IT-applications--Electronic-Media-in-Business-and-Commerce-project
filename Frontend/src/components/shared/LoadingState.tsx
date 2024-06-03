import Spinner from './Spinner';
import { cn } from '@/lib/utils';

const LoadingState = ({
  className,
  spinnerSize = 16,
}: {
  className?: string;
  spinnerSize?: number;
}) => {
  return (
    <div className={cn('flex justify-center items-center flex-1', className)}>
      <Spinner
        className={`h-${spinnerSize} w-${spinnerSize} mr-0 text-sky-950`}
      />
    </div>
  );
};
export default LoadingState;
