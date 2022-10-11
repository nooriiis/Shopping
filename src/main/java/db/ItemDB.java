package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Vector;

/*
    @authors Danilo Perovic & Zaed Noori
*/

public class ItemDB extends bo.Item {

    private ItemDB(int itemId, String itemName, int itemPrice, String itemInfo) {
        super(itemId, itemName, itemPrice, itemInfo);
    }

    /*
@param (String) s - the item to be searched
 */
    // Make a collection of the items in the DB by id
    public static Collection searchItems(String s){
        // Vector is used to add the items from the db to a collection
        Vector v = new Vector();
        try {
            //SQL query
            Connection con = DBManager.getConnection();
            PreparedStatement pre = con.prepareStatement("SELECT * FROM product WHERE itemGroup LIKE ?");
            pre.setString(1, "%" + s + "%");
            ResultSet res = pre.executeQuery();

            // Create new ItemDB with the values from DB and add it to the list
            while (res.next()) {
                v.addElement(new ItemDB(res.getInt("id"), res.getString("name"), res.getInt("price"), res.getString("info")));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return v;
    }
}
