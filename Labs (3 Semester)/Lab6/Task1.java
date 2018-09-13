import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Task1 extends JFrame {
    private JButton exit, answer;
    private JPanel mainPanel;
    private JTextField textAnswer;
    private JLabel label, mainLabel;

    Task1(){
        super("Задание 1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        creationButton();
        creationTextLabel();
        creationObjects();
        setContentPane(mainPanel);
        locateWindow();
        addWindowListener(new MyActionClose());
        addKeyListener(new MainKey());
    }

    private void creationObjects(){
        mainPanel = new JPanel(new BorderLayout());
        JPanel panelY = new JPanel();
        panelY.setLayout(new BoxLayout(panelY, BoxLayout.Y_AXIS));
        JPanel temp = new JPanel();
        temp.setLayout(new BoxLayout(temp, BoxLayout.X_AXIS));
        temp.add(Box.createHorizontalStrut(30));
        temp.add(label);
        temp.add(Box.createHorizontalStrut(30));
        temp.add(textAnswer);
        temp.add(Box.createHorizontalStrut(30));
        JPanel temp1 = new JPanel();
        temp1.setLayout(new BoxLayout(temp1, BoxLayout.X_AXIS));
        temp1.add(mainLabel);
        panelY.add(Box.createVerticalStrut(10));
        panelY.add(temp1);
        panelY.add(Box.createVerticalStrut(30));
        panelY.add(temp);
        panelY.add(Box.createVerticalStrut(30));
        mainPanel.add(panelY, BorderLayout.CENTER);
        temp = new JPanel(new FlowLayout());
        temp.add(exit);
        temp.add(answer);
        mainPanel.add(temp, BorderLayout.SOUTH);
        setContentPane(mainPanel);
    }

    private void creationButton(){
        answer = new JButton("Дать ответ");
        answer.setFocusPainted(false);
        answer.addActionListener(new GameAction());
        answer.addKeyListener(new Arrow());
        answer.addKeyListener(new MainKey());
        exit = new JButton("Вернуться в главное меню");
        exit.setFocusPainted(false);
        exit.addActionListener(new ExitAction());
    }

    private void creationTextLabel(){
        mainLabel = new JLabel("<html><h1 align = center>Игра-угадайка</h1><br>У вас есть три попытки," +
                " вы должны угадать число от 0 до 20</html>");
        label = new JLabel("Введите число: ");
        textAnswer = new JTextField();
        textAnswer.setColumns(8);
        textAnswer.addKeyListener(new MainKey());
        textAnswer.addKeyListener(new NumberKey());
        textAnswer.addKeyListener(new Arrow());
    }

    private void locateWindow(){
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth())/2);
        int y = (int) ((screenSize.getHeight() - getHeight())/2);
        setResizable(false);
        setLocation(x, y);
    }

    private boolean checkCode(int ch){
        if (ch >= KeyEvent.VK_0 && ch <= KeyEvent.VK_9 )
            return true;
        else
            return  false;
    }

    private boolean checkSpecial(int ch){
        if ( ch !=  KeyEvent.VK_BACK_SPACE && ch != KeyEvent.VK_ESCAPE && ch != KeyEvent.VK_ENTER &&
                ch != KeyEvent.VK_UP && ch != KeyEvent.VK_DOWN && ch != KeyEvent.VK_ALT  &&
                ch != KeyEvent.VK_SHIFT && ch != KeyEvent.VK_CONTROL && ch != KeyEvent.VK_CAPS_LOCK)
            return true;
        else
            return false;
    }

    class NumberKey extends KeyAdapter{
        private int symbols = 0;
        @Override
        public void keyPressed(KeyEvent e){
            if (checkSpecial(e.getKeyCode())) {
                symbols++;
                if (symbols > 1) {
                    int c = textAnswer.getText().length();
                    int temp = 0;
                    String str = new String(textAnswer.getText().substring(0, (c > 1 ? 1: c)));
                    for (int i = 0; i < str.length(); i++)
                        if (!checkCode((int) str.charAt(i))) {
                            str = str.replace(str.charAt(i), '0');
                            temp++;
                        }
                    if (temp == 2)
                        str = "";
                    textAnswer.setText(str);

                } else if (!checkCode(e.getKeyCode())) {
                    int end = textAnswer.getText().length() - 1;
                    if (end != -1) {
                        String str = new String(textAnswer.getText().substring(0, end));
                        textAnswer.setText(str);
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                symbols--;
        }
    }

    class Arrow extends KeyAdapter{
        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
                    answer.requestFocus();
            else
                if (e.getKeyCode() == KeyEvent.VK_UP)
                    textAnswer.requestFocus();
        }
    }

    class MainKey extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
                answer.doClick();
            else if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                dispose();
        }
    }

    class MyActionClose extends WindowAdapter {
        @Override
        public void windowClosed(WindowEvent e) {
            new MenuLab().setVisible(true);
        }
    }

    class GameAction implements ActionListener{
        private byte click = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            boolean check = true;
            if (textAnswer.getText().trim().length() == 0){
                JOptionPane.showMessageDialog(null, "Введите число", "Напоминание", JOptionPane.WARNING_MESSAGE);
                return;
            }
            else {
                for (char i : textAnswer.getText().toCharArray())
                    if (!checkCode( (int) i )){
                        JOptionPane.showMessageDialog(null, "Ввод букв воспрещён", "Напоминание", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
             }
                Integer temp = Integer.parseInt(textAnswer.getText());
                if (temp > 20)
                    JOptionPane.showMessageDialog(null, "Введите число от 0 до 20", "Напоминание", JOptionPane.WARNING_MESSAGE);
                else {
                    click++;
                    Random random = new Random();
                        Integer k = random.nextInt(21);
                        if (k.equals(temp)) {
                            JOptionPane.showMessageDialog(null, "Вы угадали число, победа!", "Правильный ответ", JOptionPane.PLAIN_MESSAGE);
                            dispose();
                        } else if (click == 3) {
                            JOptionPane.showMessageDialog(null, "<html>Вы проиграли<br>Загаданное число: " + k.toString() + " </html>", "Поражение", JOptionPane.PLAIN_MESSAGE);
                            dispose();
                        } else
                            JOptionPane.showMessageDialog(null, "<html>Вы не угадали число :-( <br>Загаданное число: " + k.toString() + "<br>Осталось попыток: " + (3 - click) + "</html>", "Неправильный ответ", JOptionPane.PLAIN_MESSAGE);
                    }
        }
    }

    class ExitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
