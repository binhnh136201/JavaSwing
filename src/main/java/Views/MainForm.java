package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainForm {
    MainForm() {
        JFrame frame = new JFrame();
        JButton manageAccountButton = new JButton("Quan ly tai khoan");
        JButton manageStaffButton = new JButton("Quan ly nhan vien");
        JButton statButton = new JButton("Thong ke");

        manageAccountButton.setBounds(0, 0, 150, 20);
        frame.add(manageAccountButton);

        manageStaffButton.setBounds(150, 0, 150, 20);
        frame.add(manageStaffButton);

        ActionListener manageStaffActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UserTableForm userTableForm = new UserTableForm();
                    frame.setVisible(false);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        };
        manageStaffButton.addActionListener(manageStaffActionListener);

        statButton.setBounds(300, 0, 150, 20);
        frame.add(statButton);

        frame.setLayout(null);
        frame.setSize(500, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width/2 - frame.getSize().width/2, dim.height/2 - frame.getSize().height/2);
        frame.setVisible(true);
    }
}
