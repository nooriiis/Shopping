package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

/**
 * This DB class handles queries related to the Items of the application.
 *
 * @author Zaed Noori zaedn@kth.se, Danilo Perovic perovic@kth.se
 */
public class ItemDB extends bo.Item {

    /**
     * Creates a new instance of Item.
     * @param itemId the ID.
     * @param itemName the name of the Item.
     * @param itemPrice the price of the Item.
     * @param itemInfo the info of the Item.
     */
    private ItemDB(int itemId, String itemName, int itemPrice, String itemInfo) {
        super(itemId, itemName, itemPrice, itemInfo);
    }

    /**
     * Searches through the database and retrieves all the items that matches the input String with the column itemGroup.
     * @param s the input String of the itemGroup to search.
     * @return Collection of the Items found in the database.
     */
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
