import { useSearchParams } from 'react-router-dom';

import {
  Select,
  SelectContent,
  SelectItem,
  SelectTrigger,
  SelectValue,
} from '@/components/ui/select';
import { SortEnum } from '@/constants/sorting-filters';

const Sort = () => {
  const [searchParams, setSearchParams] = useSearchParams();
  const query = searchParams.get('sort');
  const selected = query ?? SortEnum.Relevance;

  const handleSelect = (value: string) => {
    setSearchParams((params) => {
      params.set('sort', value);
      return params;
    });
  };

  return (
    <Select defaultValue={selected} onValueChange={handleSelect}>
      <SelectTrigger className="w-[180px]">
        <SelectValue placeholder={SortEnum.Relevance} />
      </SelectTrigger>
      <SelectContent>
        <SelectItem value={SortEnum.Relevance}>{SortEnum.Relevance}</SelectItem>
        <SelectItem value={SortEnum.Name}>{SortEnum.Name}</SelectItem>
        <SelectItem value={SortEnum.PriceAsc}>{SortEnum.PriceAsc}</SelectItem>
        <SelectItem value={SortEnum.PriceDesc}>{SortEnum.PriceDesc}</SelectItem>
      </SelectContent>
    </Select>
  );
};

export default Sort;
