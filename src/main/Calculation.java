package main;

import javax.swing.*;

public class Calculation {

    /*  Доступные арифмитические операции  */
    private static final String OPERATORS = "+-*/^";

    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 390, 250);
        frame.setResizable(false);
        frame.setVisible(true);

        JLabel lb = new JLabel("Input expression:");
        lb.setBounds(40,10,100,20);
        JTextField tf = new JTextField(30);
        tf.setBounds(40,30,300,25);
        JButton button = new JButton("Convert and calculate");
        button.setBounds(100,60,170,25);
        JLabel lb1 = new JLabel("OPN:");
        lb1.setBounds(40,90,100,20);
        JTextField tf1 = new JTextField(30);
        tf1.setBounds(40,110,300,25);
        JLabel lb2 = new JLabel("Result:");
        lb2.setBounds(40,140,100,20);
        JTextField tf2 = new JTextField(30);
        tf2.setBounds(40,160,150,25);
        tf1.setEditable(false);
        tf2.setEditable(false);

        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        panel.add(lb);
        panel.add(tf);
        panel.add(button);
        panel.add(lb1);
        panel.add(tf1);
        panel.add(lb2);
        panel.add(tf2);

        button.addActionListener(e -> {
            String source = tf.getText();

            ToPostfix postfix = new ToPostfix(source, OPERATORS);
            String OPN = postfix.toPostfix();
            tf1.setText(OPN);

            Calculate calc = new Calculate(OPN, OPERATORS);
            double result = calc.value();
            if (result == (int)result)  tf2.setText(Integer.toString((int)result));
            else tf2.setText(Double.toString(result));
        });
    }
}