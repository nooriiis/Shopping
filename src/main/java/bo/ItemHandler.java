package bo;

import ui.ItemInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class handles the process of getting Items from the database and return a Collection of Items to the JSP.
 *
 * @author Zaed Noori zaedn@kth.se, Danilo Perovic perovic@kth.se
 */
public class ItemHandler {

    /**
     * This method handles the process of getting a collection of Items from the database and then display it in form of ItemInfo.
     * @param s string of the name to search in the column "itemGroup" in the database.
     * @return the desired ArrayList of ItemInfo to display.
     */
    public static Collection<ItemInfo> getItems(String s){
        Collection c = Item.searchItems(s);
        ArrayList<ItemInfo> items = new ArrayList<ItemInfo>();
        for (Iterator it = c.iterator(); it.hasNext();){
            Item item = (Item) it.next();
            items.add(new ItemInfo(item.getItemId(), item.getItemName(), item.getItemPrice(), item.getItemInfo()));
        }
        return items;
    }

    /**
     * This method handles the process of getting a collection of CartItems from the database and then display it in form of ItemInfo.
     * @param cartItemSession an ArrayList of CartItems to search in the database.
     * @return the desired ArrayList of ItemInfo to display.
     */
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
