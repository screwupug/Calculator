import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static javax.swing.JTextField.*;

public class Calculator implements ActionListener {
    public JFrame window = new JFrame("Calculator");
    public JTextField input = new JTextField();
    public JTextField output = new JTextField();
    double num_1 = 0;
    double num_2 = 0;
    int operation = 0;
    double sum;

    public KeyListener keyListener = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            System.out.println(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println(e);
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
                input.setText("");
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
                result();

        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println(e);


        }
    };


    public Calculator() {

        window.setSize(500, 480);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.white);
        window.setLocationRelativeTo(null);
        window.setResizable(true);
        window.setLayout(null);

        enter_area();
        buttons();


        window.setVisible(true);



    }


    public void enter_area() {
        input.setFont(new Font("Arial", Font.BOLD, 25));
        input.setBackground(Color.WHITE);
        input.setBounds(5, 5, 280, 40);
        input.setHorizontalAlignment(RIGHT);

        window.add(input);
        input.addKeyListener(keyListener);
    }








    public void buttons() {
        String[][] arr = {{"1", "2", "3", "C"}, {"4", "5", "6", "*"}, {"7", "8", "9", "-"}, {"0", ".", "+", "/"}, {"(", ")", "="}};

        for (int i = 0; i < arr.length; i++) {
            for (int e = 0; e < arr[i].length; e++) {
                JButton jbutton = new JButton();
                jbutton.setText(arr[i][e]);
                jbutton.setFont(new Font("Arial", Font.BOLD, 25));
                jbutton.setMargin(new Insets(0, 0, 0, 0));
                if (arr[i].length == 3 && e == 2) {
                    jbutton.setBounds(16 + e * 62, 55 + i * 62, 122, 60);
                } else {
                    jbutton.setBounds(16 + e * 62, 55 + i * 62, 60, 60);
                }
                jbutton.setFocusable(false);
                window.add(jbutton);
                jbutton.addActionListener(this);
            }

        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String button_text = ((JButton) e.getSource()).getText();

        switch (button_text) {
            case "1":
                input.setText(input.getText().concat("1"));
                break;
            case "2":
                input.setText(input.getText().concat("2"));
                break;
            case "3":
                input.setText(input.getText().concat("3"));
                break;
            case "4":
                input.setText(input.getText().concat("4"));
                break;
            case "5":
                input.setText(input.getText().concat("5"));
                break;
            case "6":
                input.setText(input.getText().concat("6"));
                break;
            case "7":
                input.setText(input.getText().concat("7"));
                break;
            case "8":
                input.setText(input.getText().concat("8"));
                break;
            case "9":
                input.setText(input.getText().concat("9"));
                break;
            case "0":
                input.setText(input.getText().concat("0"));
                break;
            case ".":
                input.setText(input.getText().concat("."));
                break;
            case "C":
                input.setText("");
                break;
            case "+":
                num_1 = Double.parseDouble(input.getText());
                operation = 1;
                input.setText("");
                break;
            case "-":
                num_1 = Double.parseDouble(input.getText());
                operation = 2;
                input.setText("");
                break;
            case "*":
                num_1 = Double.parseDouble(input.getText());
                operation = 3;
                input.setText("");
                break;
            case "/":
                num_1 = Double.parseDouble(input.getText());
                operation = 4;
                input.setText("");
                break;
            case "=":
                result();

                break;

        }

    }
    private void result() {
        num_2 = Double.parseDouble(input.getText());

        switch (operation) {
            case 1:
                sum = num_1 + num_2;
                break;
            case 2:
                sum = num_1 - num_2;
                break;
            case 3:
                sum = num_1 * num_2;
                break;
            case 4:
                sum = num_1 / num_2;
                break;
            default:
                sum = 0;
        }
        input.setText("" + sum);

    }




}











