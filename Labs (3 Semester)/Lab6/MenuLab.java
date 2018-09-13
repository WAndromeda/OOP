import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuLab extends JFrame {
    private final static int N = 3;
    private Font font = new Font("Times New Roman", Font.PLAIN, 30);
    private JPanel mainPanel;
    private JButton[] buttons;
    private JLabel[] tasks;

    MenuLab(){
        super("Лабораторная работа 6 | Меню");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFont(font);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        creatingJLablel();
        creatingJButtons();
        panelAdd();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
        setContentPane(mainPanel);
        locateWindow();
    }

    private void creatingJLablel(){
        tasks = new JLabel[N];
        for (int i = 0; i < tasks.length; i++){
            tasks[i] = new JLabel("Задание " + (i+1));
            tasks[i].setFont(font);
        }
        tasks[0].setToolTipText("Игра-угадайка, которая имеет одно текстовое поле и одну кнопку. Она предложит пользователю угадать число между 0-20 и дает ему три попытки");
        tasks[1].setToolTipText("Реализация приложения Java, который имеет макет границы и надписи для каждой области в макете. Теперь определим события мыши, чтобы описать действия");
        tasks[2].setToolTipText("Реализация программу на Java с JTextArea и двумя меню. Вы должны написать прогамму, которая с помощью меню, может изменять шрифт и цвет текста, написанного в JTextArea");
    }

    private void creatingJButtons(){
        buttons = new JButton[N];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Запустить");
            buttons[i].setFont(font);
            buttons[i].setFocusPainted(false);
        }
        buttons[0].addActionListener(new ActionTask());
        buttons[1].addActionListener(new ActionTask());
        buttons[2].addActionListener(new ActionTask());
    }

    private void panelAdd(){
        int k = 0;
        mainPanel.add(Box.createVerticalStrut(30));
        JPanel[] panels = new JPanel[N];
        for (JPanel i : panels) {
            i = new JPanel();
            i.setLayout(new BoxLayout(i, BoxLayout.X_AXIS));
            i.add(Box.createHorizontalStrut(50));
            i.add(tasks[k]);
            i.add(Box.createHorizontalStrut(50));
            i.add(buttons[k]);
            i.add(Box.createHorizontalStrut(50));
            mainPanel.add(i);
            mainPanel.add(Box.createVerticalStrut(30));
            k++;
        }
    }

    private void locateWindow(){
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth())/2);
        int y = (int) ((screenSize.getHeight() - getHeight())/2);
        setResizable(false);
        setLocation(x, y);
    }

    class ActionTask implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == buttons[0])
                new Task1().setVisible(true);
            else if (e.getSource() == buttons[1])
                new Task2().setVisible(true);
            else
                new Task3().setVisible(true);
            dispose();
        }
    }

}