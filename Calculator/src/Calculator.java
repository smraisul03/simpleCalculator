import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;

    JTextField textField;

    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton additionButton, subtractionButton, multiplicationButton, divisionButton;
    JButton decimalButton, equalButton, deleteButton, clearButton, negativeButton;

    JPanel panel;

    Font myFont = new Font("Monospaced", Font.BOLD,30);

    double num1=0, num2=0, result=0;
    char operator;

    Calculator() {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);

        textField=new JTextField();
        textField.setBounds(0, 0, 500, 100);
        textField.setFont(myFont);
        textField.setEditable(false);

        additionButton = new JButton("+");
        subtractionButton = new JButton("-");
        multiplicationButton = new JButton("*");
        divisionButton = new JButton("/");
        decimalButton = new JButton(".");
        equalButton = new JButton("=");
        deleteButton = new JButton("Delete");
        clearButton =  new JButton("Clear");
        negativeButton =  new JButton("(-)");

        functionButtons[0] = additionButton;
        functionButtons[1] = subtractionButton;
        functionButtons[2] = multiplicationButton;
        functionButtons[3] = divisionButton;
        functionButtons[4] = decimalButton;
        functionButtons[5] = equalButton;
        functionButtons[6] = deleteButton;
        functionButtons[7] = clearButton;
        functionButtons[8] = negativeButton;

        for(int i=0; i<9; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);

        }

        for(int i=0; i<10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);

        }

        deleteButton.setBounds(0,100,200,50);
        clearButton.setBounds(200,100,200,50);
        negativeButton.setBounds(400, 100, 100, 50);

        panel = new JPanel();
        panel.setBounds(0,150 , 500,325);
        panel.setLayout(new GridLayout(4, 4, 0, 0));

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




        frame.add(panel);
        frame.add(deleteButton);
        frame.add(clearButton);
        frame.add(negativeButton);
        frame.add(textField);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++) {
            if(e.getSource() == numberButtons[i]) {
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

            switch(operator) {
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    result = num1 / num2;
                    break;

            }

            textField.setText(String.valueOf(result));
            num1=result;

        }

        if (e.getSource() == clearButton) {
            textField.setText("");

        }

        if (e.getSource() == deleteButton) {
            String delete = textField.getText();
            textField.setText("");

            for(int i=0;i<delete.length()-1;i++) {
                textField.setText(textField.getText()+delete.charAt(i));

            }


        }

        if (e.getSource() == negativeButton) {
            double negative = Double.parseDouble(textField.getText());
            negative*=-1;
            textField.setText(String.valueOf(negative));
        }



    }

}
