package Views;

import Controllers.RoomController;
import Models.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import static Controllers.RoomController.getConnection;

public class UserTableForm {
    JFrame frame;
    JTable userTable;
    JButton addButton;
    JButton modifyButton;
    JButton refreshButton;

    JLabel nameLabel;
    JLabel phoneNumberLabel;
    JTextField nameText;
    JTextField phoneNumberText;
    JButton add2Button;


    String[][] data = new String[10][3];
    String[] columnNames = { "Id", "Name", "Phone Number" };
    int i = 0;

    UserTableForm() throws SQLException {
        /*listTeachers = roomController.getTeacher();
        for (int i = 0; i < listTeachers.size(); i++) {
            data[i][0] = listTeachers.get(i).getId() + "";
            data[i][1] = listTeachers.get(i).getName();
            data[i][2] = listTeachers.get(i).getPhone_number();
        }*/

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(0, 50, 50, 50);

        phoneNumberLabel = new JLabel("Phone number");
        phoneNumberLabel.setBounds(0, 100, 50, 50);

        nameText = new JTextField();
        nameText.setBounds(50, 50, 100, 50);

        phoneNumberText = new JTextField();
        phoneNumberText.setBounds(50, 100, 100, 50);

        add2Button = new JButton("Add");
        add2Button.setBounds(100, 150, 100, 50);

        ActionListener add2ActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getName = nameText.getText();
                String getPhone = phoneNumberText.getText();
                try {
                    Connection con = getConnection();
                    PreparedStatement preparedStatement = con.prepareStatement("Insert into student(name, phone_number)" + "Values (?, ?)");
                    preparedStatement.setString(1, getName);
                    preparedStatement.setString(2, getPhone);
                    preparedStatement.execute();
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        };
        add2Button.addActionListener(add2ActionListener);


        Connection con = getConnection();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("Select * from student");
        while (rs.next()) {
            data[i][0] = rs.getInt(1) + "";
            data[i][1] = rs.getString(2);
            data[i][2] = rs.getString(3);
            i++;
        }

        frame = new JFrame();

        userTable = new JTable(data, columnNames);
        userTable.setBounds(0, 0, 200, 300);

        JScrollPane sp = new JScrollPane(userTable);
        addButton = new JButton("Add");
        addButton.setBounds(100, 350, 100, 50);
        frame.add(addButton);
        ActionListener addActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = getConnection();
                    Statement statement = con.createStatement();
                    PreparedStatement preparedStatement = con.prepareStatement("Insert into teacher(id, name, phone_number)" + "Values (?, ?, ?)");
                    preparedStatement.setInt(1, 5);
                    preparedStatement.setString(2, "abc");
                    preparedStatement.setString(3, "xyz");

                    preparedStatement.execute();
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        };
        addButton.addActionListener(addActionListener);

        modifyButton = new JButton("Modify");
        modifyButton.setBounds(200, 350, 100, 50);
        frame.add(modifyButton);

        refreshButton = new JButton("Refresh");
        refreshButton.setBounds(300, 350, 100, 50);
        frame.add(refreshButton);

        ActionListener refreshActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame2 = new JFrame();
                frame2.add(nameLabel);
                frame2.add(nameText);
                frame2.add(phoneNumberLabel);
                frame2.add(phoneNumberText);
                frame2.add(add2Button);

                frame2.setLayout(null);
                frame2.setSize(300, 300);
                frame2.setVisible(true);
            }
        };
        refreshButton.addActionListener(refreshActionListener);

        frame.add(sp);

        con.close();

        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new UserTableForm();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
