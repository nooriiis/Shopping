package db;

import bo.CartItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

/*
    @authors Danilo Perovic & Zaed Noori
*/

public class CartDB extends bo.CartItem{

    private CartDB(int itemId, int quantity, String itemName, int itemPrice) {
        super(itemId,quantity,itemName,itemPrice);
    }


    /*
@param (ArrayList<CartItem>) cartList - the list of items to be added to the cart
*/
    // make a collection of the items in the DB from the given cartlist
    public static Collection searchItemById(ArrayList<CartItem> cartList){
        // Vector is used to add the items from the db to a collection
        Vector v = new Vector();
        try {
            //If list is empty return empty
            if (cartList.size()>0) {
                //Loop through every item in the parameter list
                for (CartItem c : cartList) {
                    //SQL query
                    Connection con = DBManager.getConnection();
                    PreparedStatement pre = con.prepareStatement("SELECT * FROM product WHERE id = ?");
                    pre.setInt(1,c.getItemId());
                    ResultSet res = pre.executeQuery();

                    // Create new CartDB with the values from DB and add it to the list
                    while (res.next()) {
                        v.addElement(new CartDB(res.getInt("id"), c.getCartItemQuantity(), res.getString("name"), res.getInt("price")));
                    }
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return v;
    }
}
