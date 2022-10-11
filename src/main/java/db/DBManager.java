package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static DBManager instance = null;
    private Connection con = null;

    public static Connection getConnection(){
        return getInstance().con;
    }

    private static DBManager getInstance(){
        if (instance==null){
            instance=new DBManager();
        }
        return instance;
    }
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
