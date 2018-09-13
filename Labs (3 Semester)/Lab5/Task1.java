import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class Task1 extends JFrame {
    private static final int amount = 20;
    private JPanel mainPanel;
    private JButton surprise, refresh, exit;
    private MyJPanel newPanel;

    Task1(){
        super("Задание 1");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        buttonCreation();
        creationObjects(0);
        locateWindow();
        addWindowListener(new MyActionClose());
    }

    private void creationObjects(int ch){
        mainPanel = new JPanel(new BorderLayout());
        newPanel = new MyJPanel(ch);
        mainPanel.add(newPanel, BorderLayout.CENTER);
        exit.setText("Вернуться в главное меню");
        mainPanel.add(exit, BorderLayout.WEST);
        JPanel temp = new JPanel(new FlowLayout());
        refresh.setText("Обновить фигуры");
        surprise.setText("Нажмите и увидите сюрприз");
        temp.add(surprise);
        temp.add(refresh);
        mainPanel.add(temp, BorderLayout.SOUTH);
        setContentPane(mainPanel);
    }

    private void buttonCreation(){
        exit = new JButton();
        exit.setFocusPainted(false);
        exit.addActionListener(new ExitAction());
        refresh = new JButton();
        refresh.setFocusPainted(false);
        refresh.addActionListener(new RefreshAction());
        surprise = new JButton();
        surprise.addActionListener(new ButtonAction());
        surprise.setFocusPainted(false);
    }

    private void locateWindow(){
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth())/2);
        int y = (int) ((screenSize.getHeight() - getHeight())/2);
        setResizable(false);
        setLocation(x, y);
    }

    class MyJPanel extends JPanel{

        MyJPanel(int ch){
            int k = 0;
            Color[] colors = {Color.black, Color.gray, Color.LIGHT_GRAY};
            PaintFigure[] a = new PaintFigure[amount];
            setBorder(BorderFactory.createLineBorder(Color.BLUE));
            setLayout(new GridLayout(5, 4));
            for (PaintFigure i : a) {
                i = new PaintFigure(ch);
                i.setBackground(colors[k % 3]);
                add(i);
                k++;
            }
        }

    }

    class PaintFigure extends JPanel {
        private int choice;

        PaintFigure(int choice) {
            this.choice = choice;
            setBorder(BorderFactory.createLineBorder(Color.ORANGE));
            setPreferredSize(new Dimension(180, 150));
            setMinimumSize(new Dimension(50, 50));
        }

        @Override
        public void paintComponent(Graphics a) {
            super.paintComponent(a);
            Graphics2D g2 = (Graphics2D) a;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON); //Включение сглаживания
            if (choice == 0) {
                int k = 40;
                int c = 80;
                Random random = new Random();
                Shape[] shapes = {new Ellipse2D.Double(k, k, random.nextInt(c) + 20, random.nextInt(c) + 20),
                        new CubicCurve2D.Double(k, k, random.nextInt(c) + 20, random.nextInt(c) + 20, random.nextInt(c) + 20, random.nextInt(c) + 20, random.nextInt(c), random.nextInt(c)),
                        new Arc2D.Double(k, k, random.nextInt(c) + 20, random.nextInt(c) + 20, random.nextInt(c)+10, random.nextInt(c)+10, random.nextInt(3)),
                        new Rectangle2D.Double(k, k, random.nextInt(c) + 20, random.nextInt(c) + 20),
                        new RoundRectangle2D.Double(k, k, random.nextInt(c) + 20, random.nextInt(c) + 20, random.nextInt(c) + 20, random.nextInt(c) + 20),
                        new QuadCurve2D.Double(k, k, random.nextInt(c) + 20, random.nextInt(c) + 20, random.nextInt(c), random.nextInt(c)),
                        new Line2D.Double(k, k, random.nextInt(c)+50, random.nextInt(c)+50)
                };
                int r = (int) (Math.random() * 255), g = (int) (Math.random() * 255), b = (int) (Math.random() * 255);
                g2.setColor(new Color(r, g, b));
                g2.setStroke(new BasicStroke(new Random().nextInt(5) + 2));
                g2.draw(shapes[new Random().nextInt(shapes.length)]);
            }
            else{
                int[] place = new int[3];
                place[0] = 60;
                place[1] = 60;
                place[2] = 90;
                Shape[] shapeAn = {new Ellipse2D.Double(place[0], place[1], 10, 10),
                                new Ellipse2D.Double(place[0]+20, place[1], 10, 10),
                                new Ellipse2D.Double(place[0]-10, place[1]-10, 50, 40),
                                new Arc2D.Double(place[0], place[0]-5, 30 , 30 , 210, 100, Arc2D.OPEN)
                };
                int r = (int) (Math.random() * 255), g = (int) (Math.random() * 255), b = (int) (Math.random() * 255);
                g2.setColor(new Color(r, g, b));
                g2.setStroke(new BasicStroke(new Random().nextInt(5)+0.5f ));
                for (Shape i : shapeAn)
                    g2.draw(i);
            }
        }
    }

    class MyActionClose extends WindowAdapter {
        @Override
        public void windowClosed(WindowEvent e) {
            new MenuLab().setVisible(true);
        }
    }

    class ButtonAction implements ActionListener{
        private byte action = 0;
        @Override
        public void actionPerformed(ActionEvent e) {
            if (action == 0) {
                action = 1;
                newPanel = new MyJPanel(action);
                mainPanel = new JPanel(new BorderLayout());
                mainPanel.add(newPanel, BorderLayout.CENTER);
                mainPanel.add(exit, BorderLayout.WEST);
                surprise.setText("Нажмите, чтобы вернуть всё обратно");
                mainPanel.add(surprise, BorderLayout.SOUTH);
                setContentPane(mainPanel);
            }
            else{
                action = 0;
                creationObjects(action);
                repaint();
            }
        }
    }

    class RefreshAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

    class ExitAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
