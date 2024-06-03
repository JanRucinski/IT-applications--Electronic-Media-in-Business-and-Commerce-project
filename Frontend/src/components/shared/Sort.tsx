import { useSearchParams } from 'react-router-dom';

import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '@/components/ui/select';

enum SortEnum {
  Relevance = 'Relevance',
  Name = 'Name',
  Price = 'Price',
}

type SortProps = {
  value?: SortEnum;
  setValue: (value: SortEnum) => void;
};

const Sort = ({ value, setValue }: SortProps) => {
  const selected = value || SortEnum.Relevance;
  const [searchParams, setSearchParams] = useSearchParams();
  const sort = searchParams.get('sort');

  return (
    <Select defaultValue={selected} onValueChange={setValue}>
      <SelectTrigger className="w-[180px]">
        <SelectValue placeholder={SortEnum.Relevance} />
      </SelectTrigger>
      <SelectContent>
        <SelectItem value={SortEnum.Relevance}>{SortEnum.Relevance}</SelectItem>
        <SelectItem value={SortEnum.Name}>{SortEnum.Name}</SelectItem>
        <SelectItem value={SortEnum.Price}>{SortEnum.Price}</SelectItem>
      </SelectContent>
    </Select>
  );
};

export default Sort;
