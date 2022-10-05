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

    private CartDB(int itemId, String itemName, int itemPrice, int quantity) {
        super(itemId, itemName, itemPrice, quantity);
    }

    public static Collection searchItemById(ArrayList<CartItem> cartList){
        Vector v = new Vector();
        try {
            Connection con = DBManager.getConnection();
                for (CartItem c : cartList){
                    PreparedStatement pre = con.prepareStatement("SELECT * FROM product WHERE id = ?");
                    pre.setString(1, "%" + c.getItemId() + "%");
                    System.out.println("Finns:" + " " + c.getItemId());
                    ResultSet res = pre.executeQuery();
                    while (res.next()) {
                        v.addElement(new CartDB(res.getInt("id"), res.getString("name"), res.getInt("price"), res.getInt(c.getCartItemQuantity())));
                    }
                }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return v;
    }
}
