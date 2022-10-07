package bo;

import db.CartDB;

import java.util.ArrayList;
import java.util.Collection;

public class CartItem extends Item {

    private int cartItemQuantity;

    protected  CartItem(){
        super();
    }

    public CartItem(int cartItemId, int cartItemQuantity, String cartItemName, int cartItemPrice) {
        super(cartItemId,cartItemName,cartItemPrice);
        this.cartItemQuantity = cartItemQuantity;
    }

    public static Collection searchItemsById(ArrayList<CartItem> items){
        return CartDB.searchItemById(items);
    }

    public int getCartItemQuantity() {
        return cartItemQuantity;
    }

    public void setCartItemQuantity(int cartItemQuantity) {
        this.cartItemQuantity = cartItemQuantity;
    }

    @Override
    public String toString(){
        return "ID: "+ super.getItemId() +'\''+" Quantity: " + cartItemQuantity;
    }
}
