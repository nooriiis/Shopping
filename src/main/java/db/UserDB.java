package db;

import java.sql.*;

public class UserDB extends bo.User{

    private UserDB(String username, String password) {
        super(username, password);
    }

    public static boolean isUser(String username, String password){
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
            }
            if (username.equals(databaseUsername) && password.equals(databasePassword)){
                System.out.println("Successful Login!");
                return true;
            }
            else {
                System.out.println("Incorrect Password");
                return false;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
