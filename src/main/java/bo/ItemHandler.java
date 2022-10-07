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

    public static Collection<ItemInfo> getCartItems(ArrayList<CartItem> cartItemSession){
        Collection c = CartItem.searchItemsById(cartItemSession);
        ArrayList<ItemInfo> cartItems = new ArrayList<ItemInfo>();
        for (Iterator it = c.iterator(); it.hasNext();){
            CartItem item = (CartItem) it.next();
            cartItems.add(new ItemInfo(item.getItemId(), item.getCartItemQuantity(), item.getItemName(), item.getItemPrice()));
        }
        return cartItems;
    }
}
