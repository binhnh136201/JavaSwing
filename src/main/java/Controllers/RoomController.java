package Controllers;

import Models.User;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class RoomController {
    static Connection con;
    static User user;

    public RoomController() {

    }

    //JDBC and database properties.
    private static final String DB_DRIVER =
            "com.mysql.jdbc.Driver";
    private static final String DB_URL =
            "jdbc:mysql://localhost:3306/test";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "123456";
    private static String[][] dt;
    private static int i = 0;

    public static Connection getConnection() {
        Connection conn = null;
        try {
            //Open the connection
            conn = DriverManager.
                    getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            Statement state = conn.createStatement();
            ResultSet resultSet = state.executeQuery("SELECT * FROM  teacher;");
            /*while (resultSet.next()) {
            }*/


            if (conn != null) {
                System.out.println("success");
            } else {
                System.out.println("fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ArrayList<User> getTeacher() throws SQLException {
        ArrayList<User> listTeacher = new ArrayList<>();
        user = new User();
        Connection conn = getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from teacher;");
        while (resultSet.next()) {
            int teacherId = resultSet.getInt(1);
            String teacherName = resultSet.getString(2);
            String teacherPhone = resultSet.getString(3);
            user.setId(teacherId);
            user.setName(teacherName);
            user.setPhone_number(teacherPhone);
            listTeacher.add(user);
        }
        conn.close();
        return listTeacher;
    }
}
