import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Task3 extends JFrame {
    private JPanel mainPanel;
    private MyJPanel myJPanel;
    private JButton exit;

    Task3() {
        super("Задание 3");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        creationButton();
        myJPanel = new MyJPanel();
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(exit, BorderLayout.SOUTH);
        mainPanel.add(myJPanel);
        setContentPane(mainPanel);
        locateWindow();
        addWindowListener(new MyActionClose());
    }

    private void locateWindow() {
        pack();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((screenSize.getWidth() - getWidth()) / 2);
        int y = (int) ((screenSize.getHeight() - getHeight()) / 2);
        if (myJPanel.isFlag())
            setResizable(true);
        else
            setResizable(false);
        setLocation(x, y);
    }

    private void creationButton() {
        exit = new JButton("Вернуться в главное меню");
        exit.setFocusPainted(false);
        exit.addActionListener(new ExitAction());
    }

    class MyJPanel extends JPanel {
        private JMenu menu;
        private JMenuBar menuBar;
        private JMenuItem menuItem;
        private Image image;
        private JLabel label;
        private boolean flag = true, flagLabel = false;

        MyJPanel() {
            setLayout(new BorderLayout());
            creatingMenu();
            add(menuBar, BorderLayout.NORTH);
            String path = "C:\\images\\main.gif";
            setBorder(BorderFactory.createLineBorder(Color.black));
            File file = new File(path);
            if (file.exists())
                image = new ImageIcon(path).getImage();
            else {
                flag = false;
                flagLabel = true;
                label = new JLabel("<html>Картинка потерялась, но не волнуйтесь,<br> мы уже отправились на её поиски</html>");
                label.setFont(new Font("Times New Roman", Font.PLAIN, 30));
                add(label);
                JOptionPane.showMessageDialog(this, "Был указан неверный адрес к изображению", "Ошибка пути файла", JOptionPane.WARNING_MESSAGE);

            }
        }

        private void creatingMenu() {
            menuItem = new JMenuItem("Выберите изображение");
            menuItem.addActionListener(new ChooseImage());
            menu = new JMenu("Выбор файла");
            menu.add(menuItem);
            menuBar = new JMenuBar();
            menuBar.add(menu);
        }

        public void setImage(Image image) {
            this.image = image;
            flag = true;
            setPreferredSize(getPreferredSize());
            repaint();
            if (flagLabel){
                remove(label);
                flagLabel = false;
            }
        }

        public boolean isFlag() {
            return flag;
        }

        @Override
        public Dimension getPreferredSize() {
            if (flag)
                return new Dimension(image.getWidth(null),
                        image.getHeight(null)+ +5);
            else
                return super.getPreferredSize();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (flag)
                g.drawImage(image,(getWidth() - image.getWidth(null))/2,
                        (getHeight() - image.getHeight(null))/2, this);
        }
    }

    class MyActionClose extends WindowAdapter {
        @Override
        public void windowClosed(WindowEvent e) {
            new MenuLab().setVisible(true);
        }
    }

    class ExitAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }

    class ChooseImage implements ActionListener {
        JFileChooser fileChooser = new JFileChooser();

        @Override
        public void actionPerformed(ActionEvent e) {
            Image image;
            int k = fileChooser.showDialog(null, "Выберите изображение");
            if (k == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (file.exists()) {
                    image = new ImageIcon(file.getPath()).getImage();
                    myJPanel.setImage(image);
                    locateWindow();
                } else
                    JOptionPane.showMessageDialog(null, "Был указан неверный адрес к изображению", "Ошибка пути файла", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
