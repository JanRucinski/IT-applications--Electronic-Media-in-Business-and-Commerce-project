import { CardFooter } from '../../ui/card';
import { ItemCategory } from '@/types/config';
import { DeleteShopItem } from './DeleteShopItem';
import { Item } from '@/models/item';
import { EditItem } from './EditItem';

type ItemActionFooterProps = {
  item: Item;
  itemCategory: ItemCategory;
};

const ItemActionFooter = ({ item, itemCategory }: ItemActionFooterProps) => {
  return (
    <CardFooter className="flex justify-between gap-2">
      <EditItem item={item} itemCategory={itemCategory} />
      <DeleteShopItem
        itemCategory={itemCategory}
        itemId={item.id}
        buttonStyles="flex-2"
      >
        Delete
      </DeleteShopItem>
    </CardFooter>
  );
};

export default ItemActionFooter;
