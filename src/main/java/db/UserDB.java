package db;

import java.sql.*;
import java.util.Collection;
import java.util.Vector;

public class UserDB extends bo.User{

    private UserDB(String username, String password) {
        super(username, password);
    }

    public static Collection isUser(String username,String password){ // Ändra collection
        Vector v = new Vector();
        String databaseUsername = "";
        String databasePassword = "";
        try {
            Connection con = DBManager.getConnection();
            PreparedStatement pre= con.prepareStatement("SELECT * FROM user where username = ? and password = ?");
            pre.setString(1, username);
            pre.setString(2, password);
            ResultSet res = pre.executeQuery();

            while (res.next()) {
                databaseUsername = res.getString("username");
                databasePassword = res.getString("password");
                v.addElement(new UserDB(res.getString("username"), res.getString("password")));
            }
            if (username.equals(databaseUsername) && password.equals(databasePassword)){
                v.addElement(new UserDB(databaseUsername,databasePassword));
            }
            else {
                return new Vector();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return v;
    }
}
