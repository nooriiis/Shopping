package bo;

import ui.UserInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class UserHandler {
    public static Collection<UserInfo> isUser(String username, String password){
        Collection c = User.isUser(username, password);

        return getUsers(c);
    }
    public static Collection<UserInfo> getUsers(Collection c){
        ArrayList<UserInfo> users=new ArrayList<>();
        for (Iterator it = c.iterator(); it.hasNext();){
            User user = (User) it.next();
            users.add(new UserInfo(user.getUsername(), user.getPassword()));
        }
        return users;
    }
}
