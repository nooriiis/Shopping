package bo;

import db.CartDB;

import java.util.ArrayList;
import java.util.Collection;

public class CartItem extends Item{

    private int cartItemQuantity;

    protected CartItem() {

    }

    protected CartItem(int itemId, String itemName, int itemPrice, int quantity) {
        super(itemId,itemName,itemPrice,"");
        cartItemQuantity = quantity;
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
        return "Cart Item: "+ super.getItemId() +'\''+" Quantity: " + cartItemQuantity +'\''+" Name: " + super.getItemName() + " Price: " + super.getItemPrice();
    }
}
