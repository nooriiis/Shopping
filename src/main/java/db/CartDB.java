package db;

import bo.CartItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

/**
 * This DB class handles queries related to the Cart of the application.
 *
 * @author Zaed Noori zaedn@kth.se, Danilo Perovic perovic@kth.se
 */
public class CartDB extends bo.CartItem{

    /**
     * Creates a new instance of CartItem.
     * @param itemId the ID.
     * @param quantity the quantity of the CartItem.
     * @param itemName the name of the CartItem.
     * @param itemPrice the price of the CartItem.
     */
    private CartDB(int itemId, int quantity, String itemName, int itemPrice) {
        super(itemId,quantity,itemName,itemPrice);
    }


    /**
     * Searches through the database and loops through all the ID's of the CartItems in the ArrayList to retrieve information
     * about every CartItem.
     * @param cartList the ArrayList with CartItems.
     * @return a Collection of the Items found in the database.
     */
    public static Collection searchItemById(ArrayList<CartItem> cartList){
        Vector v = new Vector();
        try {
            if (cartList.size()>0) {
                for (CartItem c : cartList) {
                    Connection con = DBManager.getConnection();
                    PreparedStatement pre = con.prepareStatement("SELECT * FROM product WHERE id = ?");
                    pre.setInt(1,c.getItemId());
                    ResultSet res = pre.executeQuery();
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
