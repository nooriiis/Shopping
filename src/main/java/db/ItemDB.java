package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

public class ItemDB extends bo.Item {

    private ItemDB(int itemId, String itemName, int itemPrice, String itemInfo) {
        super(itemId, itemName, itemPrice, itemInfo);
    }

    public static Collection searchItems(String s){
        Vector v = new Vector();
        try {
            Connection con = DBManager.getConnection();
            PreparedStatement pre = con.prepareStatement("SELECT * FROM product WHERE itemGroup LIKE ?");
            pre.setString(1, "%" + s + "%");
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                v.addElement(new ItemDB(res.getInt("id"), res.getString("name"), res.getInt("price"), res.getString("info")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return v;
    }
}
