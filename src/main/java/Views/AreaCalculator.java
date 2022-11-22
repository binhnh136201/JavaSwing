package Views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AreaCalculator extends  javax.swing.JFrame{
    private JLabel shapeLabel, areaLabel, radiusLabel, widthLabel, heightLabel, resultLabel;
    private JButton button1;
    private JTextField radiusText, widthText, heightText;
    private JComboBox combobox1;
    JFrame frame;

    AreaCalculator() {
        frame = new JFrame("Area Calculator");

        //Circle
        radiusLabel = new JLabel("radius:");
        radiusText = new JTextField();
        radiusLabel.setBounds(50, 100, 150, 20);
        radiusText.setBounds(200, 100, 150, 20);
        frame.add(radiusLabel);
        frame.add(radiusText);

        //Rectangle
        widthLabel = new JLabel("width:");
        heightLabel = new JLabel("height:");
        widthText = new JTextField();
        heightText = new JTextField();

        widthLabel.setBounds(50, 100, 150, 20);
        heightLabel.setBounds(50, 150, 150, 20);
        widthText.setBounds(200, 100, 150, 20);
        heightText.setBounds(200, 150, 150, 20);
        frame.add(widthLabel);
        frame.add(heightLabel);
        frame.add(widthText);
        frame.add(heightText);
        widthLabel.setVisible(false);
        heightLabel.setVisible(false);
        widthText.setVisible(false);
        heightText.setVisible(false);

        //Combobox
        String shape[] = {"Circle", "Rectangle"};
        combobox1 = new JComboBox(shape);
        combobox1.setBounds(200, 50, 150, 20);
        ActionListener cbActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String) combobox1.getSelectedItem();

                switch (s) {
                    case "Circle":
                        chooseCircle();
                        break;
                    case "Rectangle":
                        chooseRectangle();
                        break;
                    default:
                        break;
                }
            }
        };
        combobox1.setSelectedItem(shape[0]);
        combobox1.addActionListener(cbActionListener);
        frame.add(combobox1);

        //Type of shape
        shapeLabel = new JLabel("type of shape");
        shapeLabel.setBounds(50, 50, 150, 20);
        frame.add(shapeLabel);

        //Compute button
        button1 = new JButton("compute");
        button1.setBounds(50, 200, 150, 20);
        frame.add(button1);

        //Area
        areaLabel = new JLabel("area:");
        resultLabel = new JLabel();
        areaLabel.setBounds(250, 200, 150, 20);
        resultLabel.setBounds(300, 200, 150, 20);
        frame.add(areaLabel);
        frame.add(resultLabel);

        ActionListener computeActionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = (String)combobox1.getSelectedItem();
                switch (s) {
                    case "Circle":
                        computeCircle();
                        break;
                    case "Rectangle":
                        computeRectangle();
                        break;
                    default:
                        break;
                }
            }
        };
        button1.addActionListener(computeActionListener);

        frame.setLayout(null);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    void chooseCircle() {
        widthLabel.setVisible(false);
        heightLabel.setVisible(false);
        widthText.setVisible(false);
        heightText.setVisible(false);
        radiusLabel.setVisible(true);
        radiusText.setVisible(true);
    }

    void chooseRectangle() {
        widthLabel.setVisible(true);
        heightLabel.setVisible(true);
        widthText.setVisible(true);
        heightText.setVisible(true);
        radiusLabel.setVisible(false);
        radiusText.setVisible(false);
    }

    void computeCircle() {
        int radiusInput = Integer.parseInt(radiusText.getText());
        String result = (radiusInput * radiusInput * 3.14) + "";
        resultLabel.setText(result);
    }

    void computeRectangle() {
        int widthInput = Integer.parseInt(widthText.getText());
        int heightInput = Integer.parseInt(heightText.getText());
        String result = (widthInput * heightInput) + "";
        resultLabel.setText(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AreaCalculator();
            }
        });
    }

}
