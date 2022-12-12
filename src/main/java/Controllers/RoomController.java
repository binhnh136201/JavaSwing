package Controllers;

import Models.User;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class RoomController {
    static Connection conn;
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
        conn = DriverManager.
                getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from student;");
        while (resultSet.next()) {
            user = new User();
            int studentId = resultSet.getInt(1);
            String studentName = resultSet.getString(2);
            String studentPhone = resultSet.getString(3);
            user.setId(studentId);
            user.setName(studentName);
            user.setPhone_number(studentPhone);
            listTeacher.add(user);
        }
        conn.close();
        return listTeacher;
    }

    public void updateUser(User user) throws SQLException {
        conn = DriverManager.
                getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

        String query = "UPDATE student SET name = \"" + user.getName() +
                "\" , phone_number = \" " + user.getPhone_number() +
                "\" WHERE id = " + user.getId();
        System.out.println(query);
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
        conn.close();
    }

    public void deleteUser(User user) throws SQLException {
        conn = DriverManager.
                getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        String query = "DELETE FROM student WHERE id = " + user.getId();
        Statement statement = conn.createStatement();
        statement.executeUpdate(query);
    }
}
