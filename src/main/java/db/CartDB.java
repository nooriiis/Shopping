package db;

import bo.CartItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class CartDB extends bo.CartItem{

    private CartDB(int itemId, int quantity, String itemName, int itemPrice) {
        super(itemId,quantity,itemName,itemPrice);
    }

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
