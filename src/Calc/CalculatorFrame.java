package Calc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        setTitle("Calculator");
        setBounds(50, 50, 300, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JTextField inputField = new JTextField();
        inputField.setEditable(false);
        top.add(inputField, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(5, 3));

        add(top, BorderLayout.NORTH);
        add(bottom, BorderLayout.CENTER);

        DigitButtonListener digitButtonListener = new DigitButtonListener(inputField);

        for (int i = 0; i < 10; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.addActionListener(digitButtonListener);
            bottom.add(button);
        }

        final int[] varOne = {0};
        final int[] varTwo = {0};
        final String[] operation = {""};

        JButton add = new JButton("+");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varOne[0] = Integer.valueOf(inputField.getText());
                inputField.setText("");
                operation[0] = "+";
            }
        });
        bottom.add(add);

        JButton minus = new JButton("-");
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varOne[0] = Integer.valueOf(inputField.getText());
                inputField.setText("");
                operation[0] = "-";
            }
        });
        bottom.add(minus);

        JButton sqrt = new JButton("SQRT");
        bottom.add(sqrt);

        JButton clear = new JButton("C");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int clear = 0;
                inputField.setText(String.valueOf(clear));
                varOne[0] = 0;
                operation[0] = "";
            }
        });
        bottom.add(clear);

        JButton calc = new JButton("=");
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                varTwo[0] = Integer.valueOf(inputField.getText());
                if (operation[0] == "+") {
                    inputField.setText(String.valueOf((varOne[0] + varTwo[0])));
                }
                if (operation[0] == "-") {
                    inputField.setText(String.valueOf((varOne[0] - varTwo[0])));
                }
                varOne[0] = 0;
                operation[0] = "";
            }
        });
        bottom.add(calc);

        setVisible(true);

    }
}
