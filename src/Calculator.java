import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static javax.swing.JTextField.*;

public class Calculator implements ActionListener {
    public JFrame window = new JFrame("Calculator");
    public JTextField input = new JTextField();
    int num_1 = 0;
    int num_2 = 0;
    int operation = 0;
    int sum = 0;


    public Calculator() {

        window.setSize(400, 480);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBackground(Color.WHITE);
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

        switch (button_text) {
            case "1" -> input.setText(input.getText() + "1");
            case "2" -> input.setText(input.getText() + "2");
            case "3" -> input.setText(input.getText() + "3");
            case "4" -> input.setText(input.getText() + "4");
            case "5" -> input.setText(input.getText() + "5");
            case "6" -> input.setText(input.getText() + "6");
            case "7" -> input.setText(input.getText() + "7");
            case "8" -> input.setText(input.getText() + "8");
            case "9" -> input.setText(input.getText() + "9");
            case "0" -> input.setText(input.getText() + "0");
            case "+" -> {
                num_1 = Integer.parseInt(input.getText());
                operation = 1;
                input.setText(input.getText() + "+");
            }
            case "-" -> {
                num_1 = Integer.parseInt(input.getText());
                operation = 2;
                input.setText(input.getText() + "-");
            }
            case "*" -> {
                num_1 = Integer.parseInt(input.getText());
                operation = 3;
                input.setText(input.getText() + "*");
            }
            case "/" -> {
                num_1 = Integer.parseInt(input.getText());
                operation = 4;
                input.setText(input.getText() + "/");
            }
            case "C" -> input.setText(input.getText() + "");
            case "=" -> {
                num_2 = Integer.parseInt(input.getText());
                switch (operation) {
                    case 1 -> sum = num_1 + num_2;
                    case 2 -> sum = num_1 - num_2;
                    case 3 -> sum = num_1 * num_2;
                    case 4 -> sum = num_1 / num_2;
                    default -> sum = 0;
                }
            }
        }


        if (button_text.equals("=")) {
            num_2 = Integer.parseInt(input.getText());
            switch (operation) {
                case 1 -> sum = num_1 + num_2;
                case 2 -> sum = num_1 - num_2;
                case 3 -> sum = num_1 * num_2;
                case 4 -> sum = num_1 / num_2;
                default -> sum = 0;
            }
            input.setText("" + sum);

        }
    }

}











