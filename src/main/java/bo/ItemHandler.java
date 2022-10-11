package bo;

import ui.ItemInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
    @authors Danilo Perovic & Zaed Noori
*/

public class ItemHandler {

    /*
@param (String) s - the item to be searched
 */
    public static Collection<ItemInfo> getItems(String s){
        //Get collection of items from DB
        Collection c = Item.searchItems(s);

        // create new List
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        // Loop through the collection and create the items from
        // the collection item to iteminfo and add them to the new list
        for (Iterator it = c.iterator(); it.hasNext();){
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getItemId(), item.getItemName(), item.getItemPrice(), item.getItemInfo()));
        }
        return items;
    }
    /*
@param (ArrayList<CartItem>) cartItemSession - the list of items from current session
 */
    public static Collection<ItemInfo> getCartItems(ArrayList<CartItem> cartItemSession){
        //Get collection of items from DB
        Collection c = CartItem.searchItemsById(cartItemSession);

        // create new List
        ArrayList<ItemInfo> cartItems = new ArrayList<ItemInfo>();

        // Loop through the collection and create the items from
        // the collection item to iteminfo and add them to the new list
        for (Iterator it = c.iterator(); it.hasNext();){
            CartItem item = (CartItem) it.next();
            cartItems.add(new ItemInfo(item.getItemId(), item.getCartItemQuantity(), item.getItemName(), item.getItemPrice()));
        }
        return cartItems;
    }
}
