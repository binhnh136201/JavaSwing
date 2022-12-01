package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RoomController {
    static Connection con;

    RoomController() {

    }

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/test";
        String dbClass = "com.mysql.jdbc.Driver";

        try {
            Class.forName(dbClass);
            con = DriverManager.getConnection(dbUrl, "root", "123456");
        }catch (Exception e) {
            e.printStackTrace();
        }

        String s = "create table JavaSwing";

        try {
            PreparedStatement ps = con.prepareStatement(s);
            ps.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
