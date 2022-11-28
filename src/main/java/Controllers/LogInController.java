package Controllers;

import Models.User;

public class LogInController {
    String userName = "binhnh";
    String password = "123";

    public boolean checkAuth(User userForm) {
        if (userForm.getUsername().equals(userName) && userForm.getPassword().equals(password)) {
            return true;
        }else {
            return false;
        }
    }
}
