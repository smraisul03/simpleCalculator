import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {
    JFrame frame;


    JTextField textField;

    JButton[] numberButtons = new JButton[16];
    JButton[] functionButtons = new JButton[15];
    JButton additionButton, subtractionButton, multiplicationButton, divisionButton;
    JButton decimalButton, equalButton, deleteButton, clearButton, negativeButton;
    JButton base2Button, base4Button, base8Button, base10Button, base16Button;
    JButton textButton;

    JPanel panel;

    Font myFont = new Font("Monospaced", Font.BOLD, 20);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setResizable(false);

        textField = new JTextField();
        textField.setBounds(0, 0, 500, 100);
        textField.setFont(myFont);
        textField.setEditable(false);

        base2Button = new JButton("base2");
        base4Button = new JButton("base4");
        base8Button = new JButton("base8");
        base16Button = new JButton("base16");
        additionButton = new JButton("+");
        subtractionButton = new JButton("-");
        multiplicationButton = new JButton("*");
        divisionButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("Delete");
        clearButton = new JButton("Clear");
        negativeButton = new JButton("(-)");
        base10Button = new JButton("base10");
        textButton = new JButton("Editor");

        functionButtons[0] = additionButton;
        functionButtons[1] = subtractionButton;
        functionButtons[2] = multiplicationButton;
        functionButtons[3] = divisionButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negativeButton;
        functionButtons[9] = base2Button;
        functionButtons[10] = base4Button;
        functionButtons[11] = base8Button;
        functionButtons[12] = base10Button;
        functionButtons[13] = base16Button;
        functionButtons[14] = textButton;

        for (int i = 0; i < 15; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);

        }

        for (int i = 0; i < 16; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

        }

        deleteButton.setBounds(0, 100, 100, 50);
        clearButton.setBounds(100, 100, 100, 50);
        negativeButton.setBounds(200, 100, 100, 50);
        base10Button.setBounds(300, 100, 100, 50);
        textButton.setBounds(400, 100, 100, 50);


        panel = new JPanel();
        panel.setBounds(0, 150, 500, 324);
        panel.setLayout(new GridLayout(5, 5, 0, 0));
        panel.setBackground(Color.lightGray);

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(additionButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subtractionButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplicationButton);
        panel.add(decimalButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(divisionButton);
        panel.add(base2Button);
        panel.add(base4Button);
        panel.add(base8Button);
        panel.add(base16Button);
        panel.add(base10Button);
        panel.add(textButton);


        frame.add(panel);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(negativeButton);
        frame.add(base10Button);
        frame.add(textButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Calculator();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 16; i++) {
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));

            }

        }

        if (e.getSource() == decimalButton) {
            textField.setText(textField.getText().concat("."));

        }

        if (e.getSource() == additionButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");

        }

        if (e.getSource() == subtractionButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");

        }

        if (e.getSource() == multiplicationButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");

        }

        if (e.getSource() == divisionButton) {
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");

        }

        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(textField.getText());

            switch (operator) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
            }


            textField.setText(String.valueOf(result));
            num1 = result;


        }

        if (e.getSource() == clearButton) {
            textField.setText("");

        }

        if (e.getSource() == deleteButton) {
            String delete = textField.getText();
            textField.setText("");

            for (int i = 0; i < delete.length() - 1; i++) {
                textField.setText(textField.getText() + delete.charAt(i));

            }

        }

        if (e.getSource() == negativeButton) {
            double negative = Double.parseDouble(textField.getText());
            negative *= -1;
            textField.setText(String.valueOf(negative));

        }

        if (e.getSource() == base2Button) {
            String base2ButtonConvert = Integer.toBinaryString((int) result);
            textField.setText(base2ButtonConvert);

        }

        if (e.getSource() == base4Button) {
            String base4ButtonConvert = Integer.toString((int) result, 4);
            textField.setText(base4ButtonConvert);

        }

        if (e.getSource() == base8Button) {
            String base8ButtonConvert = Integer.toOctalString((int) result);
            textField.setText(base8ButtonConvert);

        }

        if (e.getSource() == base10Button) {
            String base10ButtonConvert = Integer.toString((int) result, 10);
            textField.setText((base10ButtonConvert));

        }

        if (e.getSource() == base16Button) {
            String base16ButtonConvert = Integer.toHexString((int) result);
            textField.setText(base16ButtonConvert);

        }

        if (e.getSource() == textButton) {
            new textEditor();
        }

    }

}