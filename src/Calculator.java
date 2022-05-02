import java.awt.*;
import java.awt.event.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculator {
    public JFrame window = new JFrame();
    public JTextField input = new JTextField();

    public Calculator() {
        window.setSize(480, 405);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setBackground(Color.WHITE);
        window.setResizable(false);

        window.setVisible(true);
        enter_area();
        buttons();

    }
    public void enter_area() {


        input.setFont(new Font("Arial", Font.BOLD, 24));
        input.setBounds(16, 10, 248, 36);
        input.setBackground(Color.white);
        input.setHorizontalAlignment(JTextField.RIGHT);
        window.add(input);


        KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(e -> {
            if(e.getKeyCode() == KeyEvent.VK_ENTER)
                result();
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
                input.setText("");
            return false;

        });
    }


    public void buttons() {
        String[][] arr = {{"1","2","3","С"}, {"4","5","6","*"}, {"7","8","9","-"}, {"0",".","+","/"}, {"(",")","="}};
        JButton[][] buttons_enum = new JButton[arr.length][];

        for (int i = 0; i < buttons_enum.length; i++) {
            for (int r = 0; r < buttons_enum[i].length; r++) {
                JButton jButton = new JButton();
                jButton.setFont(new Font("Arial", Font.PLAIN, 36));
                jButton.setText(arr[i][r]);
                jButton.setMargin(new Insets(0,0,0,0));
                if (buttons_enum[i].length == 3 && r == 2)
                {
                    jButton.setBounds(16+r*62, 55+i*62, 60, 60);
                }
                else
                {
                    jButton.setBounds(16+r*62, 55+i*62, 122, 60);
                }
                jButton.setFocusable(false);

                window.add(jButton);
//                jbutton_n.addActionListener(new GoNumListener());

            }

        }
    }

    public class GoNumListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = ((JButton) e.getSource()).getText();  // получаем текст с кнопки в переменную

            if (name == "=" || name == "С") {
                //...
            } else {
                // если нажата не "=" и не "С" - добавляем в поле ввода значение кнопки
                input.setText(input.getText() + name);
            }

            if (name == "=") {  // если нажата "=" - считаем результат
                result();
            }

            if (name == "С") {  // если нажата "С" - очищаем поле ввода
                input.setText("");
            }

            window.repaint();   // перерисовываем окно
        }
    }
    private void result() {
        ScriptEngineManager factory = new ScriptEngineManager();
            ScriptEngine engine = factory.getEngineByName("JavaScript");
        try {
            input.setText("" + engine.eval(input.getText()));
        } catch (ScriptException e1) {
            //...
        }
    }
}







