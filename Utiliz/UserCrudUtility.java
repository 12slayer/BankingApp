package Utiliz;

import org.model.Message;
import org.model.User;

public interface UserCrudUtility {
    Message saveUserDetails(User user);
    User getUserDetails(int accNum);
    public void deleteUser(User user);
    User transferUserbalance(int accnum);

}
