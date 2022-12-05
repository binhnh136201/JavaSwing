package Controllers;

import Models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LogInController {
    String userName = "binhnh";
    String password = "123";

    public boolean checkAuth(User userForm) {
        if (userForm.getName().equals(userName) && userForm.getPassword().equals(password)) {
            return true;
        }else {
            return false;
        }
    }

    /*Connection conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
    Statement stmt = (Statement) conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from ");
        while (rs.next()) {
        data[i][0]=rs.getString(1);
        data[i][1]= rs.getString(2) ;
        data[i][2] =rs.getInt(3)+"";
        i++;
    }*/
}
