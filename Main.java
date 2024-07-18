import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JTextField firstNumberField, secondNumberField, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, moduloButton, clearButton;

    public Main() {
        // Create frame
        JFrame frame = new JFrame("Calculator");

        // Create text fields
        firstNumberField = new JTextField();
        secondNumberField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        // Create buttons
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        moduloButton = new JButton("%");
        clearButton = new JButton("Clear");

        // Set layout manager
        frame.setLayout(null);

        // Set bounds for text fields
        firstNumberField.setBounds(50, 40, 200, 30);
        secondNumberField.setBounds(50, 80, 200, 30);
        resultField.setBounds(50, 120, 200, 30);

        // Set bounds for buttons
        addButton.setBounds(50, 160, 50, 40);
        subtractButton.setBounds(110, 160, 50, 40);
        multiplyButton.setBounds(170, 160, 50, 40);
        divideButton.setBounds(50, 210, 50, 40);
        moduloButton.setBounds(110, 210, 50, 40);
        clearButton.setBounds(170, 210, 80, 40);

        // Add action listeners
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        moduloButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add components to frame
        frame.add(firstNumberField);
        frame.add(secondNumberField);
        frame.add(resultField);
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);
        frame.add(moduloButton);
        frame.add(clearButton);

        // Set frame properties
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(firstNumberField.getText());
            double num2 = Double.parseDouble(secondNumberField.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultField.setText("Cannot divide by zero");
                    return;
                }
            } else if (e.getSource() == moduloButton) {
                result = num1 % num2;
            } else if (e.getSource() == clearButton) {
                firstNumberField.setText("");
                secondNumberField.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
