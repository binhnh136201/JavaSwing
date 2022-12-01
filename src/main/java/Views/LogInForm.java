package Views;

import javax.swing.*;
import java.awt.*;

public class LogInForm {
    public LogInForm() {

    }

    public static void main(String[] args) {
        JFrame logInFrame = new JFrame();



        JLabel username = new JLabel("username");
        JLabel password = new JLabel("password");
        JTextField usernameField = new JTextField(20);
        JTextField passwordField = new JPasswordField(20);

        JButton submitBtn = new JButton("Submit");
        JButton resetBtn = new JButton("Reset");

        JPanel logInPanel = new JPanel();

        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();

        logInPanel.setLayout(layout);

        gbc.gridx = 0;
        gbc.gridy = 0;
        logInPanel.add(username, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        logInPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        logInPanel.add(password, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        logInPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        logInPanel.add(submitBtn);

        gbc.gridx = 1;
        gbc.gridy = 2;
        logInPanel.add(resetBtn);

        logInFrame.add(logInPanel);

        logInFrame.setSize(500, 300);
        logInFrame.setVisible(true);



    }
}
