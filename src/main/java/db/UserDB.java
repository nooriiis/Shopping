package db;

import java.sql.*;
import java.util.Collection;
import java.util.Vector;

public class UserDB extends bo.User{
    public static Collection isUser(String username,String password){
        Vector v = new Vector();
        try {
            Connection con = DBManager.getConnection();
            PreparedStatement pre= con.prepareStatement("SELECT * FROM user where username = ? and password = ?");
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet res = pre.executeQuery();

            if (res.next()) {
                v.addElement(new UserDB(res.getString("username"), res.getString("password")));
            } else {
                return new Vector();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return v;
    }

    private UserDB(String username, String password) {
        super(username, password);
    }
}
