package db;

import java.sql.*;

/**
 * This DB class handles queries related to the Login of the application.
 *
 * @author Zaed Noori zaedn@kth.se, Danilo Perovic perovic@kth.se
 */
public class UserDB extends bo.User{

    /**
     * Creates a new instance of User.
     * @param username the username.
     * @param password the name of the password.
     */
    private UserDB(String username, String password) {
        super(username, password);
    }

    /**
     * Searches through the database and checks if the credentials of the username and password is found in the database.
     * @param username the input username String.
     * @param password the input password String.
     * @return true if the User is found in the database, false if not.
     */
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
