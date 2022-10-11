package bo;

import db.CartDB;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Represents the logic methods and attributes for a cartItem.
 *
 * @author Zaed Noori zaedn@kth.se, Danilo Perovic perovic@kth.se
 */
public class CartItem extends Item {

    private int cartItemQuantity;

    /**
     * Creates a cartItem by initializing superclass Item.
     */
    protected  CartItem(){
        super();
    }

    /**
     * Creates a cartItem by initializing cartItemId, cartItemQuantity, cartItemName, cartItemPrice, by
     * initializing superclass Item.
     * @param cartItemId the ID.
     * @param cartItemQuantity the quantity of the CartItem.
     * @param cartItemName the name of the CartItem.
     * @param cartItemPrice the price of the CartItem.
     */
    public CartItem(int cartItemId, int cartItemQuantity, String cartItemName, int cartItemPrice) {
        super(cartItemId,cartItemName,cartItemPrice);
        this.cartItemQuantity = cartItemQuantity;
    }

    /**
     * Searches through the database to find the CartItems in the session.
     * @param items the CartItems of the session.
     * @return the desired CartItems from the database.
     */
    public static Collection searchItemsById(ArrayList<CartItem> items){
        return CartDB.searchItemById(items);
    }

    /**
     * Gets the Quantity of an CartItem.
     * @return the quantity.
     */
    public int getCartItemQuantity() {
        return cartItemQuantity;
    }

    /**
     * Sets the Quantity of an CartItem.
     * @param cartItemQuantity the quantity.
     */
    public void setCartItemQuantity(int cartItemQuantity) {
        this.cartItemQuantity = cartItemQuantity;
    }

    /**
     * General toString method containing the ID and Quantity.
     * @return the CartItem string.
     */
    @Override
    public String toString(){
        return "ID: "+ super.getItemId() +'\''+" Quantity: " + cartItemQuantity;
    }
}
