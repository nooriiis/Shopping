package bo;

import db.UserDB;

/**
 * Represents the logic methods and attributes for a User.
 *
 * @author Zaed Noori zaedn@kth.se, Danilo Perovic perovic@kth.se
 */
public class User {

    private String username;
    private String password;

    /**
     * Creates a User by initializing username, password.
     * @param username the username input.
     * @param password the password input.
     */
    protected User(String username, String password){
        this.username=username;
        this.password=password;
    }

    /**
     * Searches through the database to find a matching User according to the input.
     * @param username the username input.
     * @param password the password input.
     * @return true if the credentials are correct, false if not.
     */
    protected static boolean isUser(String username,String password){
        return UserDB.isUser(username,password);
    }

    /**
     * Gets the Password of a User.
     * @return the password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the Password of a User.
     * @param password the password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the Username of a User.
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the Username of a User.
     * @param username the username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * General toString method containing the username and password.
     * @return the User string.
     */
    @Override
    public String toString(){
        return "User: "+'\''+" Username: " + username+'\''+" Password: "+password;
    }
}
