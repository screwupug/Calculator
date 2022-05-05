import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static javax.swing.JTextField.*;

public class Calculator implements ActionListener {
    public JFrame window = new JFrame("Calculator");
    public JTextField input = new JTextField();
    JButton button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9, button_10, button_11, button_12, button_13, button_14, button_15;
    int num_1 = 0;
    int num_2 = 0;
    int operation = 0;
    int sum = 0;


    public Calculator() {

        window.setSize(400, 480);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(Color.BLUE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
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
    }

    public void buttons() {
        String[][] arr = {{"1", "2", "3", "C"}, {"4", "5", "6", "*"}, {"7", "8", "9", "-"}, {"0", ".", "+", "/"}, {"(", ")", "="}};

        for (int i = 0; i < arr.length; i++) {
            for (int e = 0; e < arr[i].length; e++) {
                JButton jbutton = new JButton();
                jbutton.setText(arr[i][e]);
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


        if (button_text.equals("1")) {
            input.setText("1");
        }
        if (button_text.equals("2")) {
            input.setText("2");
        }
        if (button_text.equals("3")) {
            input.setText("3");
        }
        if (button_text.equals("4")) {
            input.setText("4");
        }
        if (button_text.equals("5")) {
            input.setText("5");
        }
        if (button_text.equals("6")) {
            input.setText("6");
        }
        if (button_text.equals("7")) {
            input.setText("7");
        }
        if (button_text.equals("8")) {
            input.setText("8");
        }
        if (button_text.equals("9")) {
            input.setText("9");
        }
        if (button_text.equals("0")) {
            input.setText("0");
        }
        if (button_text.equals("+")) {
            num_1 = Integer.parseInt(input.getText());
            operation = 1;
            input.setText("+");
        }
        if (button_text.equals("-")) {
            num_1 = Integer.parseInt(input.getText());
            operation = 2;
            input.setText("-");
        }
        if (button_text.equals("*")) {
            num_1 = Integer.parseInt(input.getText());
            operation = 3;
            input.setText("*");
        }
        if (button_text.equals("/")) {
            num_1 = Integer.parseInt(input.getText());
            operation = 4;
            input.setText("/");
        }
        if (button_text.equals("C")) {
            input.setText("");
        }
        if (button_text.equals("=")) {
            num_2 = Integer.parseInt(input.getText());
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
                    if(num_1 == 0 || num_2 == 0) {
                        input.setText("Îøèáêà");
                    } else {
                        input.setText("" + sum);
                    }
                    break;
                default:
                    sum = 0;
            }
            input.setText("" + sum);

        }
    }

}











