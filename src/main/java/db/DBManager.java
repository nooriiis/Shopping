package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This DB class connects the application to the desired schema database.
 *
 * @author Zaed Noori zaedn@kth.se, Danilo Perovic perovic@kth.se
 */
public class DBManager {
    private static DBManager instance = null;
    private Connection con = null;

    /**
     * This method returns a connection to the database.
     * @return  a connection instance.
     */
    public static Connection getConnection(){
        return getInstance().con;
    }

    /**
     * This method checks if there is already an instance to the database, if not creates a new connection.
     * @return  a connection instance.
     */
    private static DBManager getInstance(){
        if (instance==null){
            instance=new DBManager();
        }
        return instance;
    }

    /**
     * This method creates a connection to the desired schema by typing in the user and password for the user management.
     */
    private DBManager(){
        //Connect to db
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping?UseClientEnc=UTF8", "adminshop", "root123.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
