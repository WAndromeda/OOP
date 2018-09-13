import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Task2 extends JFrame {
    private JLabel center, south, north, west, east;
    private JPanel mainPanel;
    private JPanel[] panels;

    Task2(){
        super("Задание 2");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        creationLabels();
        creationObjects();
        locateWindow();
        addWindowListener(new MyActionClose());
        addKeyListener(new EscapeAction());
    }

    private void creationLabels(){
        center = new JLabel("Центр Вселенной");
        south = new JLabel("Жаркий Юг, сейчас бы в отпуск");
        north = new JLabel("Здесь далёкий север");
        east = new JLabel("Волшебный востооооок, Здесь чары и мес... Кхм, ну, вы поняли");
        west = new JLabel("Самый быстрый стрелок на Диком Западе");
    }

    private void creationObjects(){
        MouseAdapter[] mouseAdapters = {new CenterMouse(), new SouthMouse(), new NorthMouse(), new EastMouse(), new WestMouse()};
        Component[] components = {center, south, north, east, west};
        mainPanel = new JPanel(new BorderLayout(30, 30));
        panels = new JPanel[5];
        for (int i = 0; i < panels.length; i++) {
            panels[i] = new JPanel(new BorderLayout());
            panels[i].add(components[i]);
            panels[i].addMouseListener(mouseAdapters[i]);
        }
        mainPanel.add(panels[0], BorderLayout.CENTER);
        mainPanel.add(panels[1], BorderLayout.SOUTH);
        mainPanel.add(panels[2], BorderLayout.NORTH);
        mainPanel.add(panels[3], BorderLayout.EAST);
        mainPanel.add(panels[4], BorderLayout.WEST);
        setContentPane(mainPanel);
    }

    private void locateWindow(){
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth())/2);
        int y = (int) ((screenSize.getHeight() - getHeight())/2);
        setResizable(false);
        setLocation(x, y);
    }

    class EscapeAction extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
                dispose();
        }
    }

    class MyActionClose extends WindowAdapter {
        @Override
        public void windowClosed(WindowEvent e) {
            new MenuLab().setVisible(true);
        }
    }

    class CenterMouse extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent e) {
            JOptionPane.showMessageDialog(null,  "Добро пожаловать в", "Сообщение" , JOptionPane.PLAIN_MESSAGE);
        }
    }

    class SouthMouse extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent e) {
            JOptionPane.showMessageDialog(null,  "Добро пожаловать в Абха", "Сообщение" , JOptionPane.PLAIN_MESSAGE);
        }
    }

    class NorthMouse extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent e) {
            JOptionPane.showMessageDialog(null,  "Добро пожаловать в Север", "Сообщение" , JOptionPane.PLAIN_MESSAGE);
        }
    }

    class EastMouse extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent e) {
            JOptionPane.showMessageDialog(null,  "Добро пожаловать в Дахране", "Сообщение" , JOptionPane.PLAIN_MESSAGE);
        }
    }

    class WestMouse extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent e) {
            JOptionPane.showMessageDialog(null,  "Добро пожаловать в Джидда", "Сообщение" , JOptionPane.PLAIN_MESSAGE);
        }
    }
    /*class MyMouseListener extends MouseAdapter{
        @Override
        public void mouseEntered(MouseEvent e) {
            String str = new String("Добро пожаловать в ");
            int x = e.getX();
            int y = e.getY();
            //JOptionPane.showMessageDialog(null,  x + " | " + y, "Сообщение" , JOptionPane.PLAIN_MESSAGE);
            if (y < 40)
                JOptionPane.showMessageDialog(null,  str + "Север", "Сообщение" , JOptionPane.PLAIN_MESSAGE);
            else
                if (x > 300 & x < 400 && y < 117 && y > 100)
                    JOptionPane.showMessageDialog(null,  str, "Сообщение" , JOptionPane.PLAIN_MESSAGE);
                else
                    if (y > 130)
                        JOptionPane.showMessageDialog(null,  str + "Абха", "Сообщение" , JOptionPane.PLAIN_MESSAGE);
                    else
                        if (x < 300 && y > 40 && y < 130)
                            JOptionPane.showMessageDialog(null,  str + "Дахране", "Сообщение" , JOptionPane.PLAIN_MESSAGE);
                        else
                            if (y > 40 && y < 130 && x > 600)
                                JOptionPane.showMessageDialog(null,  str + "Джидда", "Сообщение" , JOptionPane.PLAIN_MESSAGE);
        }
    }*/
}
