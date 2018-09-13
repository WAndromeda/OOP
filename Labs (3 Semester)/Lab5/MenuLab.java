import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MenuLab extends JFrame {
    private final static int N = 3;
    private String path = new String();
    private Font font = new Font("Times New Roman", Font.PLAIN, 30);
    private JPanel mainPanel;
    private JButton[] buttons;
    private JLabel[] tasks;

    MenuLab(){
        super("Лабораторная работа 5 | Меню");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setFont(font);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        creatingJLablel();
        creatingJButtons();
        panelAdd();
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
        setContentPane(mainPanel);
        addKeyListener(new EscapeAction());
        locateWindow();
        requestFocusInWindow();
    }

    MenuLab(String path){
        this();
        this.path =  new String(path);
    }

    private void creatingJLablel(){
        tasks = new JLabel[N];
        for (int i = 0; i < tasks.length; i++){
            tasks[i] = new JLabel("Задание " + (i+1));
            tasks[i].setFont(font);
            tasks[i].addKeyListener(new EscapeAction());
        }
        tasks[0].setToolTipText("Создать окно, нарисовать в нем 20 случайных фигур, случайного цвета. Классы фигур должны наследоваться от абстрактного класса Shape, в котором описаны свойства фигуры: цвет, позиция");
        tasks[1].setToolTipText("Создать окно, отобразить в нем картинку, путь к которой указан в аргументах командной строки");
        tasks[2].setToolTipText("Создать окно, реализовать анимацию, с помощью картинки, состоящей из нескольких кадров");
    }

    private void creatingJButtons(){
        buttons = new JButton[N];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton("Запустить");
            buttons[i].setFont(font);
            buttons[i].setFocusPainted(false);
            buttons[i].addKeyListener(new EscapeAction());
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
                new Task2(path).setVisible(true);
            else
                new Task3().setVisible(true);
            dispose();
        }
    }

    class EscapeAction extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                System.exit(0);
        }
    }

}