package bo;

import ui.ItemInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ItemHandler {

    public static Collection<ItemInfo> getItems(String s){
        Collection c = Item.searchItems(s);
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for (Iterator it = c.iterator(); it.hasNext();){
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getItemId(), item.getItemName(), item.getItemPrice(), item.getItemInfo()));
        }
        return items;
    }
}
