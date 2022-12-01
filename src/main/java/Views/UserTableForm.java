package Views;

import javax.swing.*;
import java.awt.*;

public class UserTableForm {

    JFrame frame;
    JTable userTable;
    JButton addButton;
    JButton modifyButton;
    String[][] data = {{"Abc", "xyz", "123"},
                    {"Xyz", "abc", "321"}};
    String[] columnNames = { "SDT", "Ten", "ID" };


    UserTableForm() {
        frame = new JFrame();
        userTable = new JTable(data, columnNames);
        userTable.setBounds(30, 40, 200, 300);

        JScrollPane sp = new JScrollPane(userTable);
        addButton = new JButton("Add");
        addButton.setBounds(100, 350, 50, 50);
        frame.add(addButton);

        modifyButton = new JButton("Modify");
        modifyButton.setBounds(150, 350, 50, 50);
        frame.add(modifyButton);

        frame.add(sp);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new UserTableForm();
            }
        });
    }
}
