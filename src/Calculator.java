import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Calculator extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton[] numberButtons;
    private JButton addButton, subtractButton, multiplyButton, divideButton, equalsButton, clearButton;
    private double currentValue;
    private String currentOperation;


    public Calculator() {
        setTitle("Java Calculator");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        inputField = new JTextField();
        add(inputField, BorderLayout.NORTH);


        JPanel buttonsPanel = new JPanel(new GridLayout(4, 4));


        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            buttonsPanel.add(numberButtons[i]);
        }
        addButton = createOperationButton("+");
        subtractButton = createOperationButton("-");
        multiplyButton = createOperationButton("*");
        divideButton = createOperationButton("/");
        equalsButton = createOperationButton("=");
        clearButton = createOperationButton("C");


        buttonsPanel.add(addButton);
        buttonsPanel.add(subtractButton);
        buttonsPanel.add(multiplyButton);
        buttonsPanel.add(divideButton);
        buttonsPanel.add(equalsButton);
        buttonsPanel.add(clearButton);


        add(buttonsPanel, BorderLayout.CENTER);


        pack();
        setVisible(true);
    }


    private JButton createOperationButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(this);
        return button;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();


        for (int i = 0; i < 10; i++) {
            if (source == numberButtons[i]) {
                inputField.setText(inputField.getText() + i);
                return;
            }
        }


        if (source == addButton || source == subtractButton || source == multiplyButton || source == divideButton) {
            currentValue = Double.parseDouble(inputField.getText());
            currentOperation = ((JButton) source).getText();
            inputField.setText("");
        } else if (source == equalsButton) {
            double newValue = Double.parseDouble(inputField.getText());
            double result;


            switch (currentOperation) {
                case "+":
                    result = currentValue + newValue;
                    break;
                case "-":
                    result = currentValue - newValue;
                    break;
                case "*":
                    result = currentValue * newValue;
                    break;
                case "/":
                    result = currentValue / newValue;
                    break;
                default:
                    return;
            }


            inputField.setText(String.valueOf(result));
        } else if (source == clearButton) {
            inputField.setText("");
        }
    }
    public static void main(String[] args) {
        new Calculator();
    }
}

